package com.vic.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketSingleThreadServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        final Socket clientSocket = socket.accept();
        try (clientSocket) {
            System.out.println(
                    "Accepted connection from " + clientSocket);
            OutputStream out;
            out = clientSocket.getOutputStream();
            out.write("Hi!\r\n".getBytes(
                    StandardCharsets.UTF_8));
            out.flush();
            //模擬資料處理
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // ignore on close
    }

    public static void main(String[] args) throws IOException {
        SocketSingleThreadServer server = new SocketSingleThreadServer();
        server.serve(8000);
    }
}