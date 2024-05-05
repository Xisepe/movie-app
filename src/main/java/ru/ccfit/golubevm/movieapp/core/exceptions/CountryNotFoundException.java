package ru.ccfit.golubevm.movieapp.core.exceptions;

public class CountryNotFoundException extends NotFoundException{
    public static final String MSG = "Cannot find Country";
    public CountryNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public CountryNotFoundException(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
