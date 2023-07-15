package com.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {

    //отлавливает исключения во всех контроллерах
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({NullPointerException.class, IOException.class})
    public String myExceptionalHandler(Exception e) {
        System.out.println(e);
        return "unsuccess";
    }
}
