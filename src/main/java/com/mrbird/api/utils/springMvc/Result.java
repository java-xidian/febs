package com.mrbird.api.utils.springMvc;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 对外统一返回值
 */
public class Result<T> {
    private final boolean success;
    private final int code;
    private final String message;

    private final T data;

    private Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(true, 0, "success", null);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(true, 0, message, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, 0, "success", data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(true, 0, message, data);
    }

    public static <T> Result<T> fail(AbstractResultEnum returnCode) {
        return new Result<>(false, returnCode.code(), returnCode.message(), null);
    }

    public static <T> Result<T> fail(AbstractResultEnum returnCode, String message) {
        return new Result<>(false, returnCode.code(), message, null);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(false, code, message, null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
