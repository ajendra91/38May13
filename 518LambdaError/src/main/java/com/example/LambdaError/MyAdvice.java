package com.example.LambdaError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyAdvice extends ResponseEntityExceptionHandler {

    //@ResponseBody
    @ExceptionHandler(CustomExp.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    String fun(CustomExp ce,Model model){
        model.addAttribute("msg","ajendra"+ce.getMessage());
        return "customErr";
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
        return new ResponseEntity<Object>(ex.getBindingResult().getFieldError().getDefaultMessage()+""+request.getDescription(false),HttpStatus.BAD_REQUEST);
    }
}
