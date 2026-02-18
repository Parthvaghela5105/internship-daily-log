package com.intern.globalexception.customized.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoStudentFoundException extends RuntimeException{
    private String errorMsg;
    private Integer errorCode;
    private LocalDateTime dateTime;

    public NoStudentFoundException(String errorMsg , Integer errorCode){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.dateTime=LocalDateTime.now();
    }
}
