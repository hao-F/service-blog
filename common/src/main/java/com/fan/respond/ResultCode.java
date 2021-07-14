package com.fan.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements CustomizeErrorCode {
    SUCCESS(10000, "请求成功"),
    ERROR(10001, "请求失败")
    ;


    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
