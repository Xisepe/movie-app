package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class CreatePersonRequest implements Serializable {
    @Valid
    CreateMediaSourceRequest preview;
    @Positive
    Integer citizenshipId;
    @Size(max = 128)
    String placeOfBirth;
    @DateTimeFormat
    LocalDate dateOfDeath;
    @DateTimeFormat
    LocalDate dateOfBirth;
    @Size(max = 128)
    String name;
    @Valid
    Set<@Positive Integer> crewRoleIds;
}