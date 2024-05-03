package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.CountryDto;
import ru.ccfit.golubevm.movieapp.api.CrewRoleDto;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class CreatePersonRequest implements Serializable {
    URL previewUrl;
    Integer countryId;
    String placeOfBirth;
    LocalDate dateOfDeath;
    LocalDate dateOfBirth;
    @NotBlank
    String name;
    Set<Integer> crewRoleIds;
}