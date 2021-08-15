package com.vic.spring.mybatis.mybatisdemo.user.model;

import com.vic.spring.mybatis.mybatisdemo.base.mode.BaseModel;
import lombok.Data;

@Data
public class User extends BaseModel {

    private String name;
    private Integer age;
    private String email;
}
