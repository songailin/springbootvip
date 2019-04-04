package com.easysoft.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    public String globalExceptionHandle(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        return "系统异常，请稍后再访问或联系系统管理员。";
    }
}
