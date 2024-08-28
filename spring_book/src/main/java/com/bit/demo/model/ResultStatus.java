package com.bit.demo.model;

public enum ResultStatus {
    SUCCESS(200),
    UNLOGIN(-1),
    FAIL(-2);

    private Integer code;

    ResultStatus(int code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
