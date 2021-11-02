package com.santana.java.back.end.shoppingapi.exception.advice;

import com.santana.java.back.end.shoppingapi.dto.ErrorDTO;
import com.santana.java.back.end.shoppingapi.exception.ProductNotFoundException;
import com.santana.java.back.end.shoppingapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "com.santana.java.back.end.shoppingapi.controller")
public class ShoppingControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException){
        ErrorDTO errorDTO= new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Usuário não encontrado!");
        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException){
        ErrorDTO errorDTO= new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Produto não encontrado!");
        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }
}
