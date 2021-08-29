package com.example.spring_boot.advice;

import com.example.spring_boot.model.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gubengang
 * @create 2021-08-15 12:05
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler{

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Void> errorHandler(MethodArgumentNotValidException e){
       String errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
       log.error("参数错误："+errorMsg);

       return Result.failure(errorMsg);
   }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public Result<Void> parameterTypeException(HttpMessageConversionException exception){

        log.error(exception.getCause().getLocalizedMessage());
        return Result.failure("类型转换错误");

    }
}
