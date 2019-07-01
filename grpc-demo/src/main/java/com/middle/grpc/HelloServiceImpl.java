package com.middle.grpc;

/**
 * @author 15510
 * @create 2019-06-30 20:52
 */


import com.protobuf.proto.*;
import io.grpc.stub.StreamObserver;


/**
 * 使用grpc实现
 * 实现service定义的方法，只需通过下面这种继承抽象类的方式实现。
 * 注意下面实现的方法都是写个简单例子，并不是完成相应方法的功能
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    /**
     *注意：这里发现他的返回值是void，可是我们定义service时，返回值是MyResponse啊
     * grpc跟Thrift不一样，他是通过StreamObserver来返回对象，即第二个参数
     * @param request 传入的参数对象
     * @param responseObserver 用于返回结果的对象
     */
    @Override
        public void simpleHello(Person request, StreamObserver<Result> responseObserver) {
        System.out.println("接收客户端信息："+request.getName());
        //开始返回对象（即返回值），对象的构建和protobuf一样
        responseObserver.onNext(Result.newBuilder().setString("hello" + request.getName()).build());
        //标志结束
        responseObserver.onCompleted();
    }


    @Override
    public void serverStreamHello(Person request, StreamObserver<Result> responseObserver) {
        System.out.println("接收客户端信息："+request.getName());
        //跟上个方法不一样，这是构造一个stream对象（即多个对象相当于集合）
        responseObserver.onNext(Result.newBuilder().setString("hello1" + request.getName()).build());
        responseObserver.onNext(Result.newBuilder().setString("hello2" + request.getName()).build());
        responseObserver.onNext(Result.newBuilder().setString("hello3" + request.getName()).build());
        //标志结束
        responseObserver.onCompleted();
    }


    /**
     * 从客户端接收stream，和上面两种区别蛮大的
     * 【stream的意思是可以一条一条的发送(onNext)，最后发送onCompleted表示信息发送完毕】
     *
     * 接收客户端传进来的responseStream
     * 返回一个requestStream 给客户端调用
     */
    @Override
    public StreamObserver<Person> clientStreamHello(StreamObserver<Result> responseObserver) {
        return new StreamObserver<Person>() {
            private Result.Builder builder =  Result.newBuilder();
            @Override
            public void onNext(Person value) {
                System.out.println("接收客户端信息：" + value.getName());
                builder.setString(builder.getString() + "," + value.getName());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                //最后返回一个对象给客户端【因为只能返回一个对象给客户端，所以最后返回】
                builder.setString("hello" + builder.getString());
                responseObserver.onNext(builder.build());
                responseObserver.onCompleted();
            }
        };
    }



    @Override
    public StreamObserver<Person> biStreamHello(StreamObserver<Result> responseObserver) {
        return new StreamObserver<Person>() {
            @Override
            public void onNext(Person value) {
                System.out.println("接收客户端信息：" + value.getName());
                // requestStream中来一个person对象，我返回一个result对象
                responseObserver.onNext(Result.newBuilder().setString("hello" + value.getName()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
