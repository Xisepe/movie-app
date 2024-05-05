package ru.ccfit.golubevm.movieapp.api.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCrew}
 */
@Value
public class TitleCrewPersonResponse implements Serializable {
    Integer id;
    Set<CrewRoleResponse> crewRoles;
    SlimTitleResponse title;
}