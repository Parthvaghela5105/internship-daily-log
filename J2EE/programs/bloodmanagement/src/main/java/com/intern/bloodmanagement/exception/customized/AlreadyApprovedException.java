package com.intern.bloodmanagement.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlreadyApprovedException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public AlreadyApprovedException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public AlreadyApprovedException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
