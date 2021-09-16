package com.newegg.pr.core;

/**
 * @author vic
 * @date 9/16/2021 5:21 PM
 * @description 表的字段
 */
public class TableColumn {

    private String name;

    private String code;

    private int length;

    private String dataType;

    private boolean isRequire;

    private String  regular;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isRequire() {
        return isRequire;
    }

    public void setRequire(boolean require) {
        isRequire = require;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }
}
