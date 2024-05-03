package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.CrewRole}
 */
@Value
public class CrewRoleDto implements Serializable {
    Integer id;
    String name;
}