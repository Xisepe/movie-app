package ru.ccfit.golubevm.movieapp.core.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ccfit.golubevm.movieapp.core.exceptions.BadRequestException;

@RestControllerAdvice
public class BadRequestExceptionAdvice {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(BadRequestException ex) {}
}
