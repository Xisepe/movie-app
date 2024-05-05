package ru.ccfit.golubevm.movieapp.core.exceptions;

public class PersonNotFoundException extends NotFoundException {
    public static final String MSG = "Cannot find Person";
    public PersonNotFoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public PersonNotFoundException(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
