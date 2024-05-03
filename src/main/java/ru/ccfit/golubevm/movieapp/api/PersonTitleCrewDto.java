package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCrew}
 */
@Value
public class PersonTitleCrewDto implements Serializable {
    Integer id;
    Integer order;
    Set<CrewRoleDto> crewRoles;
    PersonTitleDto title;
}