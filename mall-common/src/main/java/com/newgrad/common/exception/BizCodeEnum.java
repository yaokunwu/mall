package com.newgrad.common.exception;

public enum BizCodeEnum {
    UNKNOWN_EXCEPTION(10000, "SYSTEM UNKNOWN ERROR"),
    VALID_EXCEPTION(10001, "PARAMETER FORMATTING VALIDATION ERROR");

    private int code;
    private String msg;
    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
