package ru.ccfit.golubevm.movieapp.core.exceptions;

public class CrewRoleNotfound extends NotFoundException {
    public static final String MSG = "Cannot find CrewRole";
    public CrewRoleNotfound(Integer id) {
        super(String.format("%s with id=%d", MSG, id));
    }
    public CrewRoleNotfound(String name){
        super(String.format("%s with name=%s", MSG, name));
    }
}
