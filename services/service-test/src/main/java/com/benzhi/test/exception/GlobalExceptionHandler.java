package com.benzhi.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //全局异常处理器
public class GlobalExceptionHandler {

//    @ExceptionHandler(Throwable.class)
//    public String error(Throwable e){
//        return "";
//    }
}
