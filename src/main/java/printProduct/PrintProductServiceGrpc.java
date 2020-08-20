package printProduct;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: printproduct.proto")
public final class PrintProductServiceGrpc {

  private PrintProductServiceGrpc() {}

  public static final String SERVICE_NAME = "printProduct.PrintProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<printProduct.PowerRequest,
      printProduct.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = printProduct.PowerRequest.class,
      responseType = printProduct.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printProduct.PowerRequest,
      printProduct.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<printProduct.PowerRequest, printProduct.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = PrintProductServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (PrintProductServiceGrpc.class) {
        if ((getSwitchPowerMethod = PrintProductServiceGrpc.getSwitchPowerMethod) == null) {
          PrintProductServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<printProduct.PowerRequest, printProduct.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "printProduct.PrintProductService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printProduct.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printProduct.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrintProductServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printProduct.PrinterRequest,
      printProduct.PrinterResponse> getPrintProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printProducts",
      requestType = printProduct.PrinterRequest.class,
      responseType = printProduct.PrinterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<printProduct.PrinterRequest,
      printProduct.PrinterResponse> getPrintProductsMethod() {
    io.grpc.MethodDescriptor<printProduct.PrinterRequest, printProduct.PrinterResponse> getPrintProductsMethod;
    if ((getPrintProductsMethod = PrintProductServiceGrpc.getPrintProductsMethod) == null) {
      synchronized (PrintProductServiceGrpc.class) {
        if ((getPrintProductsMethod = PrintProductServiceGrpc.getPrintProductsMethod) == null) {
          PrintProductServiceGrpc.getPrintProductsMethod = getPrintProductsMethod = 
              io.grpc.MethodDescriptor.<printProduct.PrinterRequest, printProduct.PrinterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "printProduct.PrintProductService", "printProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printProduct.PrinterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printProduct.PrinterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrintProductServiceMethodDescriptorSupplier("printProducts"))
                  .build();
          }
        }
     }
     return getPrintProductsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrintProductServiceStub newStub(io.grpc.Channel channel) {
    return new PrintProductServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrintProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PrintProductServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrintProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PrintProductServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PrintProductServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(printProduct.PowerRequest request,
        io.grpc.stub.StreamObserver<printProduct.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public void printProducts(printProduct.PrinterRequest request,
        io.grpc.stub.StreamObserver<printProduct.PrinterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrintProductsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                printProduct.PowerRequest,
                printProduct.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getPrintProductsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                printProduct.PrinterRequest,
                printProduct.PrinterResponse>(
                  this, METHODID_PRINT_PRODUCTS)))
          .build();
    }
  }

  /**
   */
  public static final class PrintProductServiceStub extends io.grpc.stub.AbstractStub<PrintProductServiceStub> {
    private PrintProductServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrintProductServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintProductServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrintProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(printProduct.PowerRequest request,
        io.grpc.stub.StreamObserver<printProduct.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void printProducts(printProduct.PrinterRequest request,
        io.grpc.stub.StreamObserver<printProduct.PrinterResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getPrintProductsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrintProductServiceBlockingStub extends io.grpc.stub.AbstractStub<PrintProductServiceBlockingStub> {
    private PrintProductServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrintProductServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintProductServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrintProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public printProduct.PowerResponse switchPower(printProduct.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<printProduct.PrinterResponse> printProducts(
        printProduct.PrinterRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getPrintProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrintProductServiceFutureStub extends io.grpc.stub.AbstractStub<PrintProductServiceFutureStub> {
    private PrintProductServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrintProductServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintProductServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrintProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printProduct.PowerResponse> switchPower(
        printProduct.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_PRINT_PRODUCTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrintProductServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrintProductServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((printProduct.PowerRequest) request,
              (io.grpc.stub.StreamObserver<printProduct.PowerResponse>) responseObserver);
          break;
        case METHODID_PRINT_PRODUCTS:
          serviceImpl.printProducts((printProduct.PrinterRequest) request,
              (io.grpc.stub.StreamObserver<printProduct.PrinterResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrintProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrintProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return printProduct.PrintProductServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrintProductService");
    }
  }

  private static final class PrintProductServiceFileDescriptorSupplier
      extends PrintProductServiceBaseDescriptorSupplier {
    PrintProductServiceFileDescriptorSupplier() {}
  }

  private static final class PrintProductServiceMethodDescriptorSupplier
      extends PrintProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrintProductServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrintProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrintProductServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getPrintProductsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
