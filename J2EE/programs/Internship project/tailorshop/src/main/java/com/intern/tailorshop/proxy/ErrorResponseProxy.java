package com.intern.tailorshop.proxy;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseProxy {
    private String message;
    private Integer status;
    private LocalDateTime dateTime;
    private String path;
}
