package product;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import product.ProductServer;
import product.ProductServiceGrpc;
import product.Empty;
import product.productsItem;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ProductClient {
	
	private static Logger logger = Logger.getLogger(ProductServer.class.getName());
	
	private static ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
	private static ProductServiceGrpc.ProductServiceStub asyncStub;
	private static ProductServiceGrpc.ProductServiceFutureStub futureStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

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
