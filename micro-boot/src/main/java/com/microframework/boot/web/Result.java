package com.microframework.boot.web;


import java.util.Optional;

/**
 * 响应体
 *
 * @author fonlin
 * @date 2020/11/24
 */
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result() {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
    }

    public Result(final Integer code, final String message, final T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return success(ResultCode.SUCCESS, null, null);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS, null, data);
    }

    public static <T> Result<T> success(ResultCode rc, T data) {
        return success(rc, null, data);
    }

    public static <T> Result<T> success(ResultCode rc, String message, T data) {
        return new Result<>(rc.getCode(), Optional.ofNullable(message).orElse(rc.getMessage()), data);
    }

    public static <T> Result<T> fail(BsException e) {
        return fail(e.getCode(), e.getMessage(), null);
    }

    public static <T> Result<T> fail(ResultCode rc) {
        return fail(rc.getCode(), rc.getMessage(), null);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return fail(code, message, null);
    }

    public static <T> Result<T> fail(ResultCode rc, String message) {
        return fail(rc.getCode(), message, null);
    }

    public static <T> Result<T> fail(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }
}
