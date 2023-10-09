package com.aue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private Integer code;

    private String msg;

    private Object data;

    public static CommonResponse ok(Object data) {
        return new CommonResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static CommonResponse ok(Integer status, Object data) {
        return new CommonResponse(status, HttpStatus.OK.getReasonPhrase(), data);
    }
}
