import time

import grpc
import Hello_pb2
import Hello_pb2_grpc


def run():
    # 连接 rpc 服务器
    channel = grpc.insecure_channel('localhost:8888')
    # 调用 rpc 服务
    stub = Hello_pb2_grpc.HelloServiceStub(channel)

    print("-----------")
    response = stub.simpleHello(Hello_pb2.Person(name='张三'))
    print("client received: " + response.string)

    print("-----------")
    for response in stub.serverStreamHello(Hello_pb2.Person(name='李四')):
        print("client received: " + response.string)

    print("-----------")
    person_iter = iter([Hello_pb2.Person(name="张三"), Hello_pb2.Person(name="李四"), Hello_pb2.Person(name="王五")])
    print(stub.clientStreamHello(person_iter).string)

    print("-----------")
    person_iter = iter([Hello_pb2.Person(name="张三"), Hello_pb2.Person(name="李四"), Hello_pb2.Person(name="王五")])
    for response in stub.biStreamHello(person_iter):
        print(response.string)


    time.sleep(100)
    channel.close()


if __name__ == '__main__':
    run()
