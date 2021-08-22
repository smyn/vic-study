package com.vic.spring.mybatis.boot.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Response<T> {
    private boolean status;
    @JsonIgnoreProperties("handler")
    private T data;
    private String message;

    public static Response<Void> SUCCESS() {
        Response<Void> response = new Response<>();
        response.setStatus(true);
        response.setMessage("success");
        return response;
    }

    public static <T> Response<T> SUCCESS(T data) {
        return SUCCESS(data, "success");
    }

    public static <T> Response<T> SUCCESS(T data, String message) {
        Response<T> response = new Response<>();
        response.setStatus(true);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static Response<Void> FAIL(String message) {
        Response<Void> response = new Response<>();
        response.setStatus(false);
        response.setMessage(message);
        return response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
