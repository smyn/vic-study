package com.vic.bio.origin;



import com.vic.bio.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            try (Socket socket = new Socket("localhost", 8000)) {
                ObjectOutputStream outputSteam = new ObjectOutputStream(socket.getOutputStream());

                Message message = new Message();
                message.value = "For test";
                outputSteam.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
