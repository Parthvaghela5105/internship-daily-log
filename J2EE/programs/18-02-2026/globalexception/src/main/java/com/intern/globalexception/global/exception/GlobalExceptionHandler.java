package com.intern.globalexception.global.exception;

import com.intern.globalexception.customized.exception.NoStudentFoundException;
import com.intern.globalexception.exception.Response;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<Response> noStudentFoundException(NoStudentFoundException ex, HttpServletRequest req ){
        Response res = new Response();
        res.setMessage(ex.getErrorMsg());
        res.setStatus(ex.getErrorCode());
        res.setDateTime(ex.getDateTime());
        res.setPath(req.getRequestURI());
        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> runTimeException(RuntimeException ex , HttpServletRequest req){
        Response res = new Response();
        res.setMessage(ex.getMessage());
        res.setStatus(HttpStatus.NOT_FOUND.value());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());
        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }

}
