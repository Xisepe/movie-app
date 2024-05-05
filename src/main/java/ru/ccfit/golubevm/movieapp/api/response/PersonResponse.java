package ru.ccfit.golubevm.movieapp.api.response;

import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.response.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class PersonResponse implements Serializable {
    MediaSourceResponse preview;
    Integer id;
    CountryResponse citizenship;
    String placeOfBirth;
    LocalDate dateOfDeath;
    LocalDate dateOfBirth;
    String name;
    Set<CrewRoleResponse> crewRoles;
    Set<TitleCastPersonResponse> titleCasts;
    Set<TitleCrewPersonResponse> titleCrews;
}