package printProduct;

import java.io.IOException;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import printProduct.PrintProductServiceGrpc.PrintProductServiceImplBase;

public class printProductServer extends PrintProductServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(printProductServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		printProductServer printProductserver = new printProductServer();
	   
	    int port = 9091;
	    Server server = ServerBuilder.forPort(port)
	        .addService(printProductserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Power initiliased ");

        Boolean power = request.getSwitch();
        if (power) {
        	System.out.println("Computer powering on");
        }
        else {
        	System.out.println("Computer is shutting down");
        }
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	public void printProducts(PrinterRequest request, StreamObserver<PrinterResponse> responseObserver) {		 
		 int printProduct = request.getPrinter();
		 System.out.println("Checking list.." );
		 System.out.println(" Number of Products in list is: " + printProduct );
		 responseObserver.onNext(PrinterResponse.newBuilder().setPrinter(printProduct).build());
		 
		 responseObserver.onCompleted();
	}
	
}

