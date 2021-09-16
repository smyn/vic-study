package com.vic.bio.origin;



import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(8000);

        while (true) {
            Socket clientSocket = socket.accept();
            try (InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream())) {
                int data = inputStreamReader.read();
                String resource = "\ncopy that\n";
                while(data != -1) {
                    System.out.print((char) data);
                    data = inputStreamReader.read();
//                    clientSocket.getOutputStream().write(resource.getBytes());
                }

            }
        }
    }
}