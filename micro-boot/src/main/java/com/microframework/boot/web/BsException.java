package com.microframework.boot.web;


/**
 * 业务异常类
 *
 * @author fonlin
 * @date 2020/11/24
 */
public class BsException extends RuntimeException {

    private Integer code;

    public BsException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public BsException(ResultCode resultCode, Throwable cause) {
        this(resultCode.getCode(), resultCode.getMessage(), cause);
    }

    public BsException(ResultCode resultCode, String message) {
        this(resultCode.getCode(), message, null);
    }

    public BsException(ResultCode resultCode, String message, Throwable cause) {
        this(resultCode.getCode(), message, cause);
    }

    public BsException(Integer code, String message) {
        this(code, message, null);
    }

    public BsException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
