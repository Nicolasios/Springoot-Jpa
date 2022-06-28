package com.example.ty.common;


public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    REQUEST_PARAM_VALIDATE_ERROR(401, "参数校验失败"),
    API_EXCEPTION(402, "接口异常"),
    ARG_NOT_VALID_EXCEPTION(403, "缺少参数"),
    MISS_USER_TOKEN_EXCEPTION(1001, "缺少用户信息");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
