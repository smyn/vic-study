package com.vic.spring.mybatis.boot.base.dto;



public abstract class BaseForm {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
