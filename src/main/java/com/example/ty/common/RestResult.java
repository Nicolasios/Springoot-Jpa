package com.example.ty.common;


import java.io.Serializable;

public class RestResult<T> implements Serializable {
    private Integer code = 200;
    private Integer busCode = 0;
    private String message;
    private Integer costTime;
    private Throwable error;
    private T data;

    public static <T> RestResult<T> ok(T data) {
        return new RestResult(data);
    }

    public static <T> RestResult<T> ok() {
        return new RestResult((Object)null);
    }

    public RestResult() {
    }

    public RestResult(Integer code, Integer busCode, String message, T data) {
        this.code = code;
        this.busCode = busCode;
        this.message = message;
        this.data = data;
    }

    public RestResult(T data) {
        this.message = "success";
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getBusCode() {
        return this.busCode;
    }

    public void setBusCode(Integer busCode) {
        this.busCode = busCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RestResult<T> build(Integer code, String msg) {
        return new RestResult(200, code, msg, (Object)null);
    }

    public static <T> RestResult<T> build(Integer code, T data) {
        return data instanceof Exception ? new RestResult(500, code, ((Exception)data).getMessage(), (Object)null) : new RestResult(200, code, (String)null, data);
    }

    public static <T> RestResult<T> build(Integer code, String msg, T data) {
        return new RestResult(200, code, msg, data);
    }

    public static <T> RestResult<T> build(Integer code) {
        return new RestResult(200, code, (String)null, (Object)null);
    }

    public static <E> RestResult<E> ok(int code, String message) {
        RestResult<E> result = new RestResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <E> RestResult<E> ok(int code, String message, E data) {
        RestResult<E> result = new RestResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <E> RestResult<E> build(ResultCodeEnum resultCodeEnum, E data) {
        RestResult<E> result = new RestResult();
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        result.setData(data);
        return result;
    }
}
