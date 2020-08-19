package product;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import product.productsItem;
import product.productsResponse;
import io.grpc.stub.StreamObserver;

import product.ProductServiceGrpc.ProductServiceImplBase;
import product.Empty;

public class ProductServer extends ProductServiceImplBase {

	private static final Logger logger = Logger.getLogger(ProductServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		ProductServer productServer = new ProductServer();

		int port = 50051;
		Server server;
		server = ServerBuilder.forPort(port).addService(productServer).build().start();

		logger.info("Server started, listening on " + port);

		server.awaitTermination();
	}


	public StreamObserver<productsItem> productItems(final StreamObserver<productsResponse> responseObserver) {
		return new StreamObserver<productsItem>() {
			public void onNext(productsItem request) {
				StringBuilder products = new StringBuilder();

				products.append(request.getProducts());
				System.out.println(products);

				productsResponse reply = productsResponse.newBuilder().setProducts(products.toString()).build();

				responseObserver.onNext(reply);
			}

			public void onError(Throwable t) {
				System.out.println("Error, service stopped try again");
			}

			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}
}
