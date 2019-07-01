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
