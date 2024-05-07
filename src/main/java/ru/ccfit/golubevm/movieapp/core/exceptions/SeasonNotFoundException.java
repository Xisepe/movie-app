package ru.ccfit.golubevm.movieapp.core.exceptions;

public class SeasonNotFoundException extends NotFoundException{
    public static final String MSG = "Cannot find Season";
    public SeasonNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public SeasonNotFoundException(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
