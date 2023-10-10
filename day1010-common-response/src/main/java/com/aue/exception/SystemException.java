package com.aue.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SystemException extends Exception{
    private String message;
}
