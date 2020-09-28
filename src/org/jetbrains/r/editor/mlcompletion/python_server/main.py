import socketserver
import numpy as np
from utils import bind_to_free_port


class RequestHandler(socketserver.BaseRequestHandler):
    def handle(self):
        self.data = self.request.recv(4096).strip()
        print("{} wrote:".format(self.client_address[0]))
        print(self.data)
        completion_variants = ["1",
                               "something",
                               "good completion",
                               "I am in \u263a",
                               "ztrend     [60]",
                               "for(i in 1:10){",
                               "чек.тест",
                               "\"String\"",
                               "c(0, 1, 2:3, 700)"]
        scores = np.random.rand(len(completion_variants))
        answer = []
        for completion, score in zip(completion_variants, map(lambda x: "%0.2f" % x, scores)):
            answer.append(completion.encode('utf-8') + b"\n" + score.encode('utf-8'))
        answer = b"\n".join(answer)
        print(answer)
        self.request.send(answer)


host, port = "localhost", 7337
with bind_to_free_port(
    server_class=socketserver.TCPServer,
    host=host,
    start_port=port,
    handler=RequestHandler
) as server:
    server.serve_forever()