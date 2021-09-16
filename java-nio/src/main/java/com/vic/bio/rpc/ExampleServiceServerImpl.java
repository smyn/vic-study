package com.vic.bio.rpc;


import com.vic.bio.Message;

public class ExampleServiceServerImpl implements ExampleService{
    @Override
    public Message invoke() {
        Message message = new Message();
        message.value = "success";
        return message;
    }
}
