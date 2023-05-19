package com.unigo.mall.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ApiResult<T> implements Serializable {
    private static final String SUCCESS = "0";
    private static final String FAILED = "-1";

    private String status;
    private String msg;
    private T data;

    public static <T> ApiResult<T> ok() {
        return build(SUCCESS, "", null);
    }
    public static <T> ApiResult<T> ok(T data) {
        return build(SUCCESS, "", data);
    }

    public static <T> ApiResult<T> ok(String msg, T data) {
        return build(SUCCESS, msg, data);
    }

    public static <T> ApiResult<T> err() {
        return build(FAILED, "", null);
    }
    public static <T> ApiResult<T> err(String msg) {
        return build(FAILED, msg, null);
    }

    public static <T> ApiResult<T> err(String msg, T data) {
        return build(FAILED, msg, data);
    }

    public static <T> ApiResult<T> err(String status, String msg, T data) {
        return build(status, msg, data);
    }

    private static <T> ApiResult<T> build(String status, String msg, T data) {
        return (ApiResult<T>) ApiResult.builder().status(status).msg(msg).data(data).build();
    }
}
