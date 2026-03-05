package com.intern.tailorshop.controller;

import com.intern.tailorshop.exception.customized.ShopNotFoundException;
import com.intern.tailorshop.exception.customized.UserAlreadyPresent;
import com.intern.tailorshop.proxy.ErrorResponseProxy;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserAlreadyPresent.class)
    public ResponseEntity<ErrorResponseProxy> duplicateUsername(UserAlreadyPresent ex , HttpServletRequest request){
        ErrorResponseProxy errorResponseProxy = new ErrorResponseProxy();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShopNotFoundException.class)
    public ResponseEntity<ErrorResponseProxy> shopNotFoundException(ShopNotFoundException ex , HttpServletRequest request){
        ErrorResponseProxy errorResponseProxy = new ErrorResponseProxy();
        errorResponseProxy.setMessage(ex.getErrMsg());
        errorResponseProxy.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseProxy.setDateTime(ex.getDateTime());
        errorResponseProxy.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponseProxy , HttpStatus.NOT_FOUND);
    }
}
