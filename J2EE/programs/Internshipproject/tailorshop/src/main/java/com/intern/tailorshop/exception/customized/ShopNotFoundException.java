package com.intern.tailorshop.exception.customized;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopNotFoundException extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;

    public ShopNotFoundException(String message){
        this.errMsg = message;
        this.dateTime = LocalDateTime.now();
    }

    public ShopNotFoundException(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
