package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCrew}
 */
@Value
public class CreateTitleCrewRequest implements Serializable {
    @Positive
    Integer order;
    @Valid
    Set<@Positive Integer> crewRoleIds;
    @Positive
    Integer personId;
    @Positive
    Integer titleId;
}