package ru.ccfit.golubevm.movieapp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MpaaRating;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Series}
 */
@Value
public class CreateSeriesRequest implements Serializable {
    @Positive
    Integer previewId;
    Set<@Positive Integer> mediaContentIds;
    Integer id;
    @Size(max = 128)
    String ruName;
    @Size(max = 128)
    String enName;
    Set<@Positive Integer> titleCrewIds;
    Set<@Positive Integer> titleCastIds;
    @NotBlank
    @Size(max = 128)
    String originalName;
    @Size(max = 128)
    String tagline;
    LocalDate releaseDate;
    MpaaRating mpaaRating;
    @Positive
    Integer ageConstraint;
    @Positive
    Integer duration;
    @Positive
    Integer originalCountryId;
    Set<@Positive Integer> genreIds;
    Set<@Positive Integer> seasonIds;
}