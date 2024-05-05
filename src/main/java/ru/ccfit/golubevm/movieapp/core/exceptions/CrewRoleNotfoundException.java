package ru.ccfit.golubevm.movieapp.core.exceptions;

public class CrewRoleNotfoundException extends NotFoundException {
    public static final String MSG = "Cannot find CrewRole";
    public CrewRoleNotfoundException(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public CrewRoleNotfoundException(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
