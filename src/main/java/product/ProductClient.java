package product;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


import product.ProductServer;
import product.ProductServiceGrpc;
import product.Empty;
import product.productsItem;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import product.ProductClient.SampleListener;

public class ProductClient {
	
	
	
	
	
	private static Logger logger = Logger.getLogger(ProductServer.class.getName());
	
	private static ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
	private static ProductServiceGrpc.ProductServiceStub asyncStub;
	private static ProductServiceGrpc.ProductServiceFutureStub futureStub;
	
	
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
                    if(!serviceName.equalsIgnoreCase("product_service"))
                    	return;
		}
	}
	
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

		//stubs -- generate from proto
		blockingStub = ProductServiceGrpc.newBlockingStub(channel);
		asyncStub = ProductServiceGrpc.newStub(channel);
		futureStub = ProductServiceGrpc.newFutureStub(channel);
		
		productItems();
	}
	

	
	public static void productItems(){

		StreamObserver<productsResponse> responseObserver = new StreamObserver<productsResponse>() {

			@Override
			public void onNext(productsResponse value) {
				System.out.println("The products in the list are: " + value.getProducts());
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

			}

		};

		StreamObserver<productsItem> requestObserver = asyncStub.productItems(responseObserver);
		try {

			requestObserver.onNext(productsItem.newBuilder().setProducts("Pen").build());
			requestObserver.onNext(productsItem.newBuilder().setProducts("Paper").build());
			requestObserver.onNext(productsItem.newBuilder().setProducts("Pencil").build());
			requestObserver.onNext(productsItem.newBuilder().setProducts("Eraser").build());
			requestObserver.onNext(productsItem.newBuilder().setProducts("Parer").build());

			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		requestObserver.onCompleted();
	}
	
}
