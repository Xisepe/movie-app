package ru.ccfit.golubevm.movieapp.core.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ccfit.golubevm.movieapp.core.exceptions.NoContentException;

@RestControllerAdvice
public class NoContentExceptionAdvice {
    @ExceptionHandler(value = {NoContentException.class})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleNoContentException(NoContentException ex) {

    }
}
