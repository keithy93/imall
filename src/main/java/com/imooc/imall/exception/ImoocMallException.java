package com.imooc.imall.exception;

public class ImoocMallException extends RuntimeException{
    private final Integer code;
    private final String msg;
    public ImoocMallException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ImoocMallException(ImoocMallExceptionEnum ex) {
        this(ex.getCode(), ex.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
