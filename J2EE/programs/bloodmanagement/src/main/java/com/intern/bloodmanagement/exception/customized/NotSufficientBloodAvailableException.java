package com.intern.bloodmanagement.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotSufficientBloodAvailableException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public NotSufficientBloodAvailableException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public NotSufficientBloodAvailableException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
