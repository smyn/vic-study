package com.vic.bio.http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketOioHttpServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        final Socket clientSocket = socket.accept();
        try (clientSocket) {
            System.out.println(
                    "Accepted connection from " + clientSocket);
            httpService(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ignore on close
    }

    private void httpService(Socket clientSocket) throws IOException {
        parseRequest(clientSocket);
        sendResponse(clientSocket);
        clientSocket.close();
    }

    private void parseRequest(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        String request = new String(buffer);
        System.out.println("Client request data : " + request);
    }

    private void sendResponse(Socket socket) throws IOException {
        String header = "HTTP/1.1 200 OK\r\n";
        String type = "Content-Type:application/json\r\n";
        String host = "Host: 127.0.0.1\r\n";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        out.write(header);
        out.write(type);
        out.write(host);
        out.write("\r\n");
        out.write("{'value':'test'}");
        out.flush();
        System.out.println("Finish response");
    }

    public static void main(String[] args) throws IOException {
        SocketOioHttpServer server = new SocketOioHttpServer();
        server.serve(8000);
    }
}