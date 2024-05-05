package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.*;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class CreatePersonRequest implements Serializable {
    MediaSourceResponse mediaSourceResponse;
    Integer countryId;
    String placeOfBirth;
    LocalDate dateOfDeath;
    LocalDate dateOfBirth;
    @NotBlank
    String name;
    Set<CrewRoleDto> crewRoleIds;
    Set<PersonTitleCastDto> titleCastIds;
    Set<PersonTitleCrewDto> titleCrewIds;
}