package printProduct;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import printProduct.printProductClient.SampleListener;

public class printProductClient {
	
	
	public static class SampleListener implements ServiceListener {
		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
                    ServiceInfo info = event.getInfo();
                    int port = info.getPort();
                    String serviceName = info.getName();
                    System.out.println("Grpc Service Resolved");
                    System.out.println(info);
                    if(!serviceName.equalsIgnoreCase("printer_service"))
                    	return;
		}
	}
	
	
	

	private static PrintProductServiceGrpc.PrintProductServiceBlockingStub blockingStub;
	private static PrintProductServiceGrpc.PrintProductServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener("_grpc._tcp.local.", new SampleListener());

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
		
		
		
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

		blockingStub = PrintProductServiceGrpc.newBlockingStub(channel);
		asyncStub = PrintProductServiceGrpc.newStub(channel);

		switchPower();
		printProducts();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(true).build();
		PowerResponse response = blockingStub.switchPower(request);

		if (response.getSwitch()) {
			System.out.println("Computer powering on");
		}
		else {
			System.out.println("Computer is now shutting down");
		}

    }
	
	public static void printProducts() {
		PrinterRequest request = PrinterRequest.newBuilder().setPrinter(5).build();
		System.out.println("Number of products listed is " + request + " Products");

		StreamObserver<PrinterResponse> responseObserver = new StreamObserver<PrinterResponse>() {

			@Override
			public void onNext(PrinterResponse value) {
				System.out.println("Number of products in list is" + value + " Products" );

			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("on completed ");
			}

		};

		asyncStub.printProducts(request, responseObserver);


		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}