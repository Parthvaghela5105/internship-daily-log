package com.intern.fullprojectimplemantation.proxy;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Response {
    private String message;
    private Integer status;
    private LocalDateTime dateTime;
    private String path;
}
