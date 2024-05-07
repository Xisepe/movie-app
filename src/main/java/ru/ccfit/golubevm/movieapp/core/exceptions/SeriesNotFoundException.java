package ru.ccfit.golubevm.movieapp.core.exceptions;

public class SeriesNotFoundException extends NotFoundException{
    public static final String MSG = "Cannot find Series";
    public SeriesNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public SeriesNotFoundException(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
