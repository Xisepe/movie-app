package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.request.CreateTitleCastRequest;
import ru.ccfit.golubevm.movieapp.api.request.CreateTitleCrewRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MpaaRating;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Series}
 */
@Value
public class CreateSeriesRequest implements Serializable {
    @Valid
    CreateMediaSourceRequest preview;
    @Valid
    Set<CreateMediaSourceRequest> mediaContent;
    @Size(max = 128)
    String ruName;
    @Size(max = 128)
    String enName;
    @NotBlank
    @Size(max = 128)
    String originalName;
    @Size(max = 128)
    String tagline;
    @DateTimeFormat
    LocalDate releaseDate;
    @Valid
    MpaaRating mpaaRating;
    @Positive
    Integer ageConstraint;
    @Positive
    Integer duration;
    @Valid
    Set<CreateTitleCrewRequest> titleCrews;
    @Valid
    Set<CreateTitleCastRequest> titleCasts;
}