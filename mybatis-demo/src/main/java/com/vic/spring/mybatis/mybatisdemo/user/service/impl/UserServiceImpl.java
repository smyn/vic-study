package com.vic.spring.mybatis.mybatisdemo.user.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vic.spring.mybatis.mybatisdemo.base.service.BaseService;
import com.vic.spring.mybatis.mybatisdemo.user.dto.form.UserForm;
import com.vic.spring.mybatis.mybatisdemo.user.dto.query.UserQuery;
import com.vic.spring.mybatis.mybatisdemo.user.model.User;
import com.vic.spring.mybatis.mybatisdemo.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User, UserForm, UserQuery> implements IUserService {

    @Override
    protected BaseMapper<User> mapper() {
        return null;
    }

    @Override
    protected User model() {
        return null;
    }
}
