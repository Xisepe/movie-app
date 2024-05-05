package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class UpdatePersonRequest implements Serializable {
    Integer previewId;
    Integer citizenshipId;
    String placeOfBirth;
    LocalDate dateOfDeath;
    LocalDate dateOfBirth;
    @NotBlank
    String name;
    Set<Integer> crewRoleIds;
    Set<Integer> titleCastIds;
    Set<Integer> titleCrewIds;
}