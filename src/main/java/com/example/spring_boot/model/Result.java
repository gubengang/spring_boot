package com.example.spring_boot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gubengang
 * @create 2021-08-15 11:29
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private T data;

    /**
     * 成功
     */
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(EnumResultCode.SUCCESS.getCode());
        result.setMessage(EnumResultCode.SUCCESS.getMessage());
        return result;
    }

    /**
     * 成功，有返回数据
     */
    public static <V> Result<V> success(V data) {
        Result<V> result = new Result<>();
        result.code = EnumResultCode.SUCCESS.getCode();
        result.message = EnumResultCode.SUCCESS.getMessage();
        result.data = data;
        return result;
    }

    /**
     * 失败
     */
    public static Result<Void> failure() {
        Result<Void> result = new Result<>();
        result.setCode(EnumResultCode.FAILURE.getCode());
        result.setMessage(EnumResultCode.FAILURE.getMessage());
        return result;
    }

    /**
     * 失败，自定义失败信息
     */
    public static Result<Void> failure(String message) {
        Result<Void> result = new Result<>();
        result.setCode(EnumResultCode.FAILURE.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 失败，使用已定义枚举
     */
    public static Result<Void> failure(EnumResultCode resultCode) {
        Result<Void> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }
}
