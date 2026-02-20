package com.intern.validationdemo.exception.global;

import com.intern.validationdemo.customized.exception.NoStudentFoundException;
import com.intern.validationdemo.exception.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<Response> noStudentFoundException(NoStudentFoundException ex , HttpServletRequest req){
        Response res = new Response();
        res.setMessage(ex.getErrorMsg());
        res.setStatus(ex.getErrorCode());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());
        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> runtimeException(RuntimeException ex, HttpServletRequest req ){
        Response res = new Response();
        res.setMessage(ex.getMessage());
        res.setStatus(HttpStatus.NOT_FOUND.value());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());
        return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> argumentException(MethodArgumentNotValidException ex){
        Map<String , String > errorMap=new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(err -> errorMap.put(err.getField() , err.getDefaultMessage()));
        return new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
    }
}
