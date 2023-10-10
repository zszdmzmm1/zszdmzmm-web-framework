package com.aue.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BusinessException extends Exception {
    private String message;
}
