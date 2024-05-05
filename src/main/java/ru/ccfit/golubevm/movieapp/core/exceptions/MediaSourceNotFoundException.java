package ru.ccfit.golubevm.movieapp.core.exceptions;

public class MediaSourceNotFoundException extends NotFoundException {
    public static final String MSG = "Cannot find CrewRole";
    public MediaSourceNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
}
