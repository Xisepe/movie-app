package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.Positive;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.request.SlimPersonResponse;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCrew}
 */
@Value
public class TitleCrewResponse implements Serializable {
    Integer id;
    @Positive
    Integer order;
    Set<CrewRoleResponse> crewRoles;
    SlimPersonResponse person;
}