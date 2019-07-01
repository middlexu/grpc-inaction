package com.protobuf.proto;

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
 * <pre>
 *这是protobuf中定义service的方法，跟thrift差不多，但是关键字不一样
 *service中有四种rpc方法类型
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: Hello.proto")
public final class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final String SERVICE_NAME = "com.protobuf.proto.HelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getSimpleHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "simpleHello",
      requestType = com.protobuf.proto.Person.class,
      responseType = com.protobuf.proto.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getSimpleHelloMethod() {
    io.grpc.MethodDescriptor<com.protobuf.proto.Person, com.protobuf.proto.Result> getSimpleHelloMethod;
    if ((getSimpleHelloMethod = HelloServiceGrpc.getSimpleHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSimpleHelloMethod = HelloServiceGrpc.getSimpleHelloMethod) == null) {
          HelloServiceGrpc.getSimpleHelloMethod = getSimpleHelloMethod = 
              io.grpc.MethodDescriptor.<com.protobuf.proto.Person, com.protobuf.proto.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.protobuf.proto.HelloService", "simpleHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("simpleHello"))
                  .build();
          }
        }
     }
     return getSimpleHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getServerStreamHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStreamHello",
      requestType = com.protobuf.proto.Person.class,
      responseType = com.protobuf.proto.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getServerStreamHelloMethod() {
    io.grpc.MethodDescriptor<com.protobuf.proto.Person, com.protobuf.proto.Result> getServerStreamHelloMethod;
    if ((getServerStreamHelloMethod = HelloServiceGrpc.getServerStreamHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getServerStreamHelloMethod = HelloServiceGrpc.getServerStreamHelloMethod) == null) {
          HelloServiceGrpc.getServerStreamHelloMethod = getServerStreamHelloMethod = 
              io.grpc.MethodDescriptor.<com.protobuf.proto.Person, com.protobuf.proto.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.protobuf.proto.HelloService", "serverStreamHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("serverStreamHello"))
                  .build();
          }
        }
     }
     return getServerStreamHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getClientStreamHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStreamHello",
      requestType = com.protobuf.proto.Person.class,
      responseType = com.protobuf.proto.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getClientStreamHelloMethod() {
    io.grpc.MethodDescriptor<com.protobuf.proto.Person, com.protobuf.proto.Result> getClientStreamHelloMethod;
    if ((getClientStreamHelloMethod = HelloServiceGrpc.getClientStreamHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getClientStreamHelloMethod = HelloServiceGrpc.getClientStreamHelloMethod) == null) {
          HelloServiceGrpc.getClientStreamHelloMethod = getClientStreamHelloMethod = 
              io.grpc.MethodDescriptor.<com.protobuf.proto.Person, com.protobuf.proto.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.protobuf.proto.HelloService", "clientStreamHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("clientStreamHello"))
                  .build();
          }
        }
     }
     return getClientStreamHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getBiStreamHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biStreamHello",
      requestType = com.protobuf.proto.Person.class,
      responseType = com.protobuf.proto.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.protobuf.proto.Person,
      com.protobuf.proto.Result> getBiStreamHelloMethod() {
    io.grpc.MethodDescriptor<com.protobuf.proto.Person, com.protobuf.proto.Result> getBiStreamHelloMethod;
    if ((getBiStreamHelloMethod = HelloServiceGrpc.getBiStreamHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getBiStreamHelloMethod = HelloServiceGrpc.getBiStreamHelloMethod) == null) {
          HelloServiceGrpc.getBiStreamHelloMethod = getBiStreamHelloMethod = 
              io.grpc.MethodDescriptor.<com.protobuf.proto.Person, com.protobuf.proto.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.protobuf.proto.HelloService", "biStreamHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.protobuf.proto.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("biStreamHello"))
                  .build();
          }
        }
     }
     return getBiStreamHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    return new HelloServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloServiceFutureStub(channel);
  }

  /**
   * <pre>
   *这是protobuf中定义service的方法，跟thrift差不多，但是关键字不一样
   *service中有四种rpc方法类型
   * </pre>
   */
  public static abstract class HelloServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *1.发送一个request请求，返回一个result响应
     * </pre>
     */
    public void simpleHello(com.protobuf.proto.Person request,
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getSimpleHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *2.发送一个request请求，返回一个stream响应
     *虽然我们这里只是想传入一个int32（age），但是protobuf传入的参数必须是message类型，和thrift不同
     *thrift是可以直接传入int，详细可看thrift
     * </pre>
     */
    public void serverStreamHello(com.protobuf.proto.Person request,
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *3.发送一个stream请求，返回一个result响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.protobuf.proto.Person> clientStreamHello(
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *4.发送stream请求，返回一个stream响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.protobuf.proto.Person> biStreamHello(
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiStreamHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimpleHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.protobuf.proto.Person,
                com.protobuf.proto.Result>(
                  this, METHODID_SIMPLE_HELLO)))
          .addMethod(
            getServerStreamHelloMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.protobuf.proto.Person,
                com.protobuf.proto.Result>(
                  this, METHODID_SERVER_STREAM_HELLO)))
          .addMethod(
            getClientStreamHelloMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.protobuf.proto.Person,
                com.protobuf.proto.Result>(
                  this, METHODID_CLIENT_STREAM_HELLO)))
          .addMethod(
            getBiStreamHelloMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.protobuf.proto.Person,
                com.protobuf.proto.Result>(
                  this, METHODID_BI_STREAM_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   *这是protobuf中定义service的方法，跟thrift差不多，但是关键字不一样
   *service中有四种rpc方法类型
   * </pre>
   */
  public static final class HelloServiceStub extends io.grpc.stub.AbstractStub<HelloServiceStub> {
    private HelloServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *1.发送一个request请求，返回一个result响应
     * </pre>
     */
    public void simpleHello(com.protobuf.proto.Person request,
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSimpleHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *2.发送一个request请求，返回一个stream响应
     *虽然我们这里只是想传入一个int32（age），但是protobuf传入的参数必须是message类型，和thrift不同
     *thrift是可以直接传入int，详细可看thrift
     * </pre>
     */
    public void serverStreamHello(com.protobuf.proto.Person request,
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *3.发送一个stream请求，返回一个result响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.protobuf.proto.Person> clientStreamHello(
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamHelloMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *4.发送stream请求，返回一个stream响应
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.protobuf.proto.Person> biStreamHello(
        io.grpc.stub.StreamObserver<com.protobuf.proto.Result> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiStreamHelloMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *这是protobuf中定义service的方法，跟thrift差不多，但是关键字不一样
   *service中有四种rpc方法类型
   * </pre>
   */
  public static final class HelloServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloServiceBlockingStub> {
    private HelloServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *1.发送一个request请求，返回一个result响应
     * </pre>
     */
    public com.protobuf.proto.Result simpleHello(com.protobuf.proto.Person request) {
      return blockingUnaryCall(
          getChannel(), getSimpleHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *2.发送一个request请求，返回一个stream响应
     *虽然我们这里只是想传入一个int32（age），但是protobuf传入的参数必须是message类型，和thrift不同
     *thrift是可以直接传入int，详细可看thrift
     * </pre>
     */
    public java.util.Iterator<com.protobuf.proto.Result> serverStreamHello(
        com.protobuf.proto.Person request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *这是protobuf中定义service的方法，跟thrift差不多，但是关键字不一样
   *service中有四种rpc方法类型
   * </pre>
   */
  public static final class HelloServiceFutureStub extends io.grpc.stub.AbstractStub<HelloServiceFutureStub> {
    private HelloServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *1.发送一个request请求，返回一个result响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.protobuf.proto.Result> simpleHello(
        com.protobuf.proto.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getSimpleHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE_HELLO = 0;
  private static final int METHODID_SERVER_STREAM_HELLO = 1;
  private static final int METHODID_CLIENT_STREAM_HELLO = 2;
  private static final int METHODID_BI_STREAM_HELLO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE_HELLO:
          serviceImpl.simpleHello((com.protobuf.proto.Person) request,
              (io.grpc.stub.StreamObserver<com.protobuf.proto.Result>) responseObserver);
          break;
        case METHODID_SERVER_STREAM_HELLO:
          serviceImpl.serverStreamHello((com.protobuf.proto.Person) request,
              (io.grpc.stub.StreamObserver<com.protobuf.proto.Result>) responseObserver);
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
        case METHODID_CLIENT_STREAM_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamHello(
              (io.grpc.stub.StreamObserver<com.protobuf.proto.Result>) responseObserver);
        case METHODID_BI_STREAM_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biStreamHello(
              (io.grpc.stub.StreamObserver<com.protobuf.proto.Result>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.protobuf.proto.HelloInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloService");
    }
  }

  private static final class HelloServiceFileDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier {
    HelloServiceFileDescriptorSupplier() {}
  }

  private static final class HelloServiceMethodDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloServiceFileDescriptorSupplier())
              .addMethod(getSimpleHelloMethod())
              .addMethod(getServerStreamHelloMethod())
              .addMethod(getClientStreamHelloMethod())
              .addMethod(getBiStreamHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
