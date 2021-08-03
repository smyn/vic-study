package com.vic.spring.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWordController {

    @GetMapping("hello")
    public String helloGet(){
        return "1";
    }

    @PostMapping("hello")
    public String helloPost(){
        return "1";
    }

    @DeleteMapping("hello")
    public String helloDelete(){
        return "1";
    }

    @PutMapping("hello")
    public String helloPut(){
        return "1";
    }

}
