package com.vic.bio.rpc;



import com.vic.bio.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Stack;

public class ExampleServiceClientImpl implements ExampleService {

    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    @Override
    public Message invoke() {
        return (Message) getRemoteResult();
    }

    private Object getRemoteResult() {

        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());) {

            ExampleRequest request = new ExampleRequest();
            request.setMethod("invoke");

            objectOutputStream.writeObject(request);
            Object response = objectInputStream.readObject();

            Stack<String> stack = new Stack<>();
            if (response instanceof Message) {
                return response;
            } else {
                throw new InternalError();
            }

        } catch (Exception e) {
            throw new InternalError();
        }
    }
}
