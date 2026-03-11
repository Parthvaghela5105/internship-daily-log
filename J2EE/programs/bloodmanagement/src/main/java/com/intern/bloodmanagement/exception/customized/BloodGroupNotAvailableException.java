package com.intern.bloodmanagement.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BloodGroupNotAvailableException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public BloodGroupNotAvailableException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public BloodGroupNotAvailableException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
