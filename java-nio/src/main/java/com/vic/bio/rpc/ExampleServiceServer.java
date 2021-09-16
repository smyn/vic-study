package com.vic.bio.rpc;



import com.vic.bio.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExampleServiceServer {
    private static final int PORT = 8000;

    private ExampleService rpcService = new ExampleServiceServerImpl();

    public void start() throws IOException {
        System.out.println("Server start");
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();

            try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());) {

                Object object = objectInputStream.readObject();
                System.out.println("Get request");
                Message result = new Message();
                System.out.println(object);
                if (object instanceof ExampleRequest) {
                    ExampleRequest request = (ExampleRequest) object;
                    if ("invoke".equals(request.getMethod())) {
                        result = rpcService.invoke();
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    System.out.println("I don't have any object match this request");
                }

                objectOutputStream.writeObject(result);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ExampleServiceServer().start();
    }
}

