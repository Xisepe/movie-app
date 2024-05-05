package ru.ccfit.golubevm.movieapp.core.exceptions;

public class GenreNotFoundException extends NotFoundException {
    public static final String MSG = "Cannot find Genre";
    public GenreNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
}
