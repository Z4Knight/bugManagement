package com.z4knight.bugmanagement.exception;

import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

/**
 * @Author Z4knight
 * @Date 2018/1/29 14:50
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServletException.class)
    public Result handleException(Exception e) {

        return ResultGenerator.genFailResultWithAuthorize(e.getMessage());
    }
}
