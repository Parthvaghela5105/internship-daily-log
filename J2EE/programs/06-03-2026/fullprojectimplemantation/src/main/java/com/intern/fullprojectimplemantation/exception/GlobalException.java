package com.intern.fullprojectimplemantation.exception;

import com.intern.fullprojectimplemantation.exception.customized.NoEmployeeFoundException;
import com.intern.fullprojectimplemantation.proxy.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoEmployeeFoundException.class)
    public ResponseEntity<Response> noEmployee(NoEmployeeFoundException exception , HttpServletRequest request){
        Response res = Response.builder()
                .message(exception.getErrMsg())
                .dateTime(LocalDateTime.now())
                .path(request.getRequestURI())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }
}
