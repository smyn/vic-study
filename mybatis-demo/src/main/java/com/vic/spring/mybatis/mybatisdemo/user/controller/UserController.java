package com.vic.spring.mybatis.mybatisdemo.user.controller;


import com.vic.spring.mybatis.mybatisdemo.base.controller.BaseController;

import com.vic.spring.mybatis.mybatisdemo.user.dto.form.UserForm;
import com.vic.spring.mybatis.mybatisdemo.user.dto.query.UserQuery;
import com.vic.spring.mybatis.mybatisdemo.user.model.User;
import com.vic.spring.mybatis.mybatisdemo.user.service.IUserService;

import com.vic.spring.mybatis.mybatisdemo.base.dto.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController  extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("{id}")
    public Response<User> getById(@PathVariable("id") Long id ){
        return Response.SUCCESS(userService.selectById(id));
    }

    @GetMapping
    public Response<IPage<User>> getPage(UserQuery query){
        return Response.SUCCESS(userService.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody  @Valid UserForm form){
        return Response.SUCCESS(userService.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid UserForm form){
        return Response.SUCCESS(userService.updateById(form));
    }

    @PostMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id ){
        return Response.SUCCESS(userService.deleteById(id));
    }
}
