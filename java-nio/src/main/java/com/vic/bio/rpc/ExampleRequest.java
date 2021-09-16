package com.vic.bio.rpc;

import java.io.Serializable;

public class ExampleRequest implements Serializable {
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
