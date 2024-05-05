package ru.ccfit.golubevm.movieapp.core.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ccfit.golubevm.movieapp.core.exceptions.NotFoundException;

@RestControllerAdvice
public class NotFoundExceptionAdvice {
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(NotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEntityNotFoundException(EntityNotFoundException ex) {
        return "Passed invalid input data. Check for correct id";
    }
}
