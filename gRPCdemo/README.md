安装：
gRPC 的安装：

```bash
$ pip install grpcio
```

安装 ProtoBuf 相关的 python 依赖库：

```bash
$ pip install protobuf
```

安装 python grpc 的 protobuf 编译工具：

```bash
$ pip install grpcio-tools
```





Hello.proto定义了四种通信方式


```protobuf
service HelloService{
    //1.发送一个request请求，返回一个result响应
    rpc simpleHello(Person) returns (Result){}

    //2.发送一个request请求，返回一个stream响应
    //虽然我们这里只是想传入一个int32（age），但是protobuf传入的参数必须是message类型，和thrift不同
    //thrift是可以直接传入int，详细可看thrift
    rpc serverStreamHello(Person) returns (stream Result){}

    //3.发送一个stream请求，返回一个result响应
    rpc clientStreamHello(stream Person) returns (Result){}

    //4.发送stream请求，返回一个stream响应
    rpc biStreamHello(stream Person) returns (stream Result){}

}
```






```bash
# 编译 proto 文件
python -m grpc_tools.protoc --python_out=. --grpc_python_out=. -I. Hello.proto


python -m grpc_tools.protoc: python 下的 protoc 编译器通过 python 模块(module) 实现, 所以说这一步非常省心
--python_out=. : 编译生成处理 protobuf 相关的代码的路径, 这里生成到当前目录
--grpc_python_out=. : 编译生成处理 grpc 相关的代码的路径, 这里生成到当前目录
-I. helloworld.proto : proto 文件的路径, 这里的 proto 文件在当前目录
```





编译后生成的代码:

1.  `Hello_pb2.py`: 用来和 protobuf 数据进行交互
2.  `Hello_pb2_grpc.py`: 用来和 grpc 进行交互



**怎么处理流式数据呢?**. 答案是 `for-in + yield`









服务端代码

```python
from concurrent import futures
import time
import grpc
import Hello_pb2
import Hello_pb2_grpc


# 实现 proto 文件中定义的 HelloService
class HelloService(Hello_pb2_grpc.HelloServiceServicer):
    # 实现 proto 文件中定义的 rpc 调用
    def simpleHello(self, request, context):
        print("收到客户端信息：" + request.name)
        return Hello_pb2.Result(string='hello {msg}'.format(msg=request.name))

    def serverStreamHello(self, request, context):
        print("收到客户端信息：" + request.name)
        for i in range(3):
            yield Hello_pb2.Result(string='hello{cishu} {msg}'.format(cishu=i,msg=request.name))

    def clientStreamHello(self, request_iterator, context):
        res = "hello "
        for person in request_iterator:
            print("收到客户端信息：" + person.name)
            res += person.name
        return Hello_pb2.Result(string=res)

    def biStreamHello(self, request_iterator, context):
        for person in request_iterator:
            print("收到客户端信息：" + person.name)
            yield Hello_pb2.Result(string="hello {msg}".format(msg=person.name))


def serve():
    # 启动 rpc 服务
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=8))
    Hello_pb2_grpc.add_HelloServiceServicer_to_server(HelloService(), server)
    server.add_insecure_port('[::]:8888')
    server.start()
    try:
        while True:
            time.sleep(60*60*24)  # one day in seconds
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()

```







客户端代码

```python
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

```

