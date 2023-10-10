package com.aue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private Integer code;

    private String msg;

    private Object data;

    public static R ok(Object data) {
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static R ok(Integer status, Object data) {
        return new R(status, HttpStatus.OK.getReasonPhrase(), data);
    }
}
