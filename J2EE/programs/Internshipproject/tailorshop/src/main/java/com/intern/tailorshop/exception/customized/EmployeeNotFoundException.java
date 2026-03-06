package com.intern.tailorshop.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeNotFoundException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public EmployeeNotFoundException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public EmployeeNotFoundException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
