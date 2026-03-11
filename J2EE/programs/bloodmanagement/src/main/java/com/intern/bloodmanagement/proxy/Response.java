package com.intern.bloodmanagement.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;
    private Integer status;
    private LocalDateTime dateTime;
    private String path;
}
