package com.vic.spring.mybatis.mybatisdemo.user.service;

import com.vic.spring.mybatis.mybatisdemo.base.service.IBaseService;
import com.vic.spring.mybatis.mybatisdemo.user.dto.form.UserForm;
import com.vic.spring.mybatis.mybatisdemo.user.dto.query.UserQuery;
import com.vic.spring.mybatis.mybatisdemo.user.model.User;

public interface IUserService extends IBaseService<User, UserForm, UserQuery> {
}
