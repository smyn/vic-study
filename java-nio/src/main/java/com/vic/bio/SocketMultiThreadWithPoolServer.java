package com.vic.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocketMultiThreadWithPoolServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        Executor threadPool = Executors.newFixedThreadPool(10);
        try {
            while (true) {
                final Socket clientSocket = socket.accept();
                System.out.println(
                        "Accepted connection from " + clientSocket);
                threadPool.execute(() -> {
                    OutputStream out;
                    try (clientSocket) {
                        out = clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(
                                StandardCharsets.UTF_8));
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // ignore on close
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        SocketMultiThreadWithPoolServer server = new SocketMultiThreadWithPoolServer();
        server.serve(8000);
    }
}