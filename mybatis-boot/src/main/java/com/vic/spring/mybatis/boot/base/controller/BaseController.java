package com.vic.spring.mybatis.boot.base.controller;


import com.vic.spring.mybatis.boot.base.dto.Response;

public abstract class BaseController {
    public Response<Void> SUCCESS() {
        return Response.SUCCESS();
    }

    public <T> Response<T> SUCCESS(T data) {
        return Response.SUCCESS(data);
    }

    public <T> Response<T> SUCCESS(T data, String message) {
        return Response.SUCCESS(data, message);
    }

    public Response<Void> FAIL(String message) {
        return Response.FAIL(message);
    }
}
