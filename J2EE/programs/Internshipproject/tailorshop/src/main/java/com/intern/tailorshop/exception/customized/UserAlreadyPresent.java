package com.intern.tailorshop.exception.customized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyPresent extends RuntimeException{
    private String errMsg;
    private Integer errCode;
    private LocalDateTime dateTime;


    public UserAlreadyPresent(String message , Integer status){
        this.errMsg = message;
        this.errCode = status;
        this.dateTime = LocalDateTime.now();
    }
}
