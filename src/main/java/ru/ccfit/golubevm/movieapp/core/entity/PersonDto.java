package ru.ccfit.golubevm.movieapp.core.entity;

import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link Person}
 */
@Value
public class PersonDto implements Serializable {
    MediaSourceDto preview;
    Integer id;
    CountryDto citizenship;
    String placeOfBirth;
    LocalDate dateOfDeath;
    LocalDate dateOfBirth;
    Set<CrewRoleDto> crewRoles;
    Set<PersonTitleCastDto> titleCasts;
    Set<PersonTitleCrewDto> titleCrews;
}