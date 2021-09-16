package com.vic.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 8000);
                    InputStream in = socket.getInputStream();
                    StringBuilder result = new StringBuilder();
                    new BufferedReader(new InputStreamReader(in))
                            .lines().forEach(result::append);
                    socket.close();
                    System.out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}