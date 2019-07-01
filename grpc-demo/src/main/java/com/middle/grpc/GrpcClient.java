package com.middle.grpc;

import com.protobuf.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author 15510
 * @create 2019-06-30 20:59
 */


public class GrpcClient {

    private final ManagedChannel channel;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                                  // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                                  // needing certificates.
                                  .usePlaintext()
                                  .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    GrpcClient(ManagedChannel channel) {
        this.channel = channel;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        GrpcClient client = new GrpcClient("localhost", 8888);
        // 阻塞的，客户端不能发起流式的请求
        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(client.channel);
        // 非阻塞的
        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(client.channel);


        Result result = blockingStub.simpleHello(Person.newBuilder().setName("张三").build());
        System.out.println(result.getString());
        System.out.println("-------------------");


        //返回的流对象其实就是个迭代器对象，通过迭代器取
        Iterator<Result> iterator = blockingStub.serverStreamHello(Person.newBuilder().setName("李四").build());
        //
        while (iterator.hasNext()) {
            result = iterator.next();
            System.out.println(result.getString());
        }
        System.out.println("-------------------");



        StreamObserver<Result> studentResponseListStreamObserver = new StreamObserver<Result>() {
            @Override
            public void onNext(Result value) {
                System.out.println(value.getString());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        };

        StreamObserver<Person> personRequestStreamObserver = stub.clientStreamHello(studentResponseListStreamObserver);
        //客户端通过返回的StreamObserver()对象发起流式请求
        personRequestStreamObserver.onNext(Person.newBuilder().setName("张三").build());
        personRequestStreamObserver.onNext(Person.newBuilder().setName("李四").build());
        personRequestStreamObserver.onNext(Person.newBuilder().setName("王五").build());
        personRequestStreamObserver.onCompleted();
        System.out.println("-------------------");





        personRequestStreamObserver = stub.biStreamHello(new StreamObserver<Result>() {
            @Override
            public void onNext(Result value) {
                System.out.println(value.getString());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        for (int i = 0; i < 10; i++) {
            personRequestStreamObserver.onNext(Person.newBuilder().setName("laowang" + i).build());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        personRequestStreamObserver.onCompleted();



        client.shutdown();
    }

}
