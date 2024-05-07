package ru.ccfit.golubevm.movieapp.api.request;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCrew}
 */
@Value
public class CreateTitleCrewRequest implements Serializable {
    Integer order;
    Set<Integer> crewRoleIds;
    Integer personId;
    Integer titleId;
}