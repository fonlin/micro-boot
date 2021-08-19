package com.microframework.boot.web;

/**
 * 通用异常枚举，你可以实现 {@link ResultCode} 来自定义自己的异常码
 *
 * @author fonlin
 * @date 2020/11/24
 */
public enum ResultEnum implements ResultCode {

    //1000～1999 区间表示参数错误
    PARAM_IS_INVALID(1001, "系统开小差了，请联系系统管理员"),
    PARAM_IS_BLANK(1002, "系统开小差了，请联系系统管理员"),
    PARAM_TYPE_ERROR(1003, "系统开小差了，请联系系统管理员"),

    //2000～2999 区间表示用户错误
    USER_ERROR_PASSWORD(2000, "用户名密码错误"),
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_NOT_EXIST(2002, "用户不存在"),
    USER_IS_EXIST(2003, "用户已存在"),
    USER_IS_DISABLED(2004, "用户被禁用"),
    USER_IS_FORBIDDEN(2005, "用户访问禁止"),
    INVALID_TOKEN(2006, "系统开小差了，请联系系统管理员"),
    EMAIL_IS_NULL(2007, "邮箱为空"),
    USER_NOT_AUTHENTICATED(2008, "系统开小差了，请联系系统管理员"),

    //3000～3999 区间表示服务内部异常
    NULL_POINT(3002, "系统开小差了，请联系系统管理员"),
    ARRAY_INDEX_OUT_OF_BOUND(3003, "系统开小差了，请联系系统管理员"),
    NUMBER_FORMAT(3004, "系统开小差了，请联系系统管理员"),
    PARSE_ERROR(3005, "系统开小差了，请联系系统管理员"),
    CLASS_CAST(3006, "系统开小差了，请联系系统管理员"),
    ARITH_ERROR(3007, "系统开小差了，请联系系统管理员"),
    ILLEGAL_ARGUMENT(3008, "系统开小差了，请联系系统管理员"),
    BUFFER_OVERFLOW(3009, "系统开小差了，请联系系统管理员"),
    ILLEGAL_ACCESS(3010, "系统开小差了，请联系系统管理员"),
    INTERRUPTED_ERROR(3011, "系统开小差了，请联系系统管理员"),
    STRING_INDEX_OUT_OF_BOUND(3012, "系统开小差了，请联系系统管理员"),
    NO_SUCH_FIELD(3013, "系统开小差了，请联系系统管理员"),
    IO_ERROR(3014, "系统开小差了，请联系系统管理员"),
    SQL_ERROR(3015, "系统开小差了，请联系系统管理员"),
    INTERNAL_SERVER_ERROR(3016, "系统开小差了，请联系系统管理员"),
    NO_SUCH_METHOD(3017, "系统开小差了，请联系系统管理员"),
    HTTP_CLIENT_ERROR(3018, "系统开小差了，请联系系统管理员"),
    NOT_FOUND(3019, "系统开小差了，请联系系统管理员"),
    FILE_ERROR(3020, "文件上传失败"),
    SAVE_ERROR(3021, "保存失败"),
    FIELD_NULL_ERROR(3022, "系统开小差了，请联系系统管理员"),
    ILLEGAL_STATE(3023, "系统开小差了，请联系系统管理员"),
    CLASS_NOT_FOUND(3024, "系统开小差了，请联系系统管理员");


    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
