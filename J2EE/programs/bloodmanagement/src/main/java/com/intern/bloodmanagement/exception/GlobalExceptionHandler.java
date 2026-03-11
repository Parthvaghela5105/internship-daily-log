package com.intern.bloodmanagement.exception;

import com.intern.bloodmanagement.exception.customized.AlreadyApprovedException;
import com.intern.bloodmanagement.exception.customized.BloodGroupNotAvailableException;
import com.intern.bloodmanagement.exception.customized.NotSufficientBloodAvailableException;
import com.intern.bloodmanagement.exception.customized.UserNotFoundException;
import com.intern.bloodmanagement.proxy.Response;
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
    @ExceptionHandler(NotSufficientBloodAvailableException.class)
    public ResponseEntity<Response> notSufficientBlood(NotSufficientBloodAvailableException ex , HttpServletRequest request){
        Response errorResponseProxy = new Response();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BloodGroupNotAvailableException.class)
    public ResponseEntity<Response> BloodGroupNotAvailable(BloodGroupNotAvailableException ex , HttpServletRequest request){
        Response errorResponseProxy = new Response();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyApprovedException.class)
    public ResponseEntity<Response> alreadyApproved(AlreadyApprovedException ex , HttpServletRequest request){
        Response errorResponseProxy = new Response();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> argumentException(MethodArgumentNotValidException ex){
        Map<String , String > errorMap=new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(err -> errorMap.put(err.getField() , err.getDefaultMessage()));
        return new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> userNotFound(UserNotFoundException ex , HttpServletRequest request){
        Response errorResponseProxy = new Response();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> runtimeException(RuntimeException ex , HttpServletRequest request){
        Response errorResponseProxy = new Response();
        errorResponseProxy.setMessage(ex.getMessage());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(LocalDateTime.now());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }
}

