package com.intern.fullprojectimplemantation.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoEmployeeFoundException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public NoEmployeeFoundException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public NoEmployeeFoundException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
