package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Season}
 */
@Value
public class CreateSeasonRequest implements Serializable {
    @Valid
    CreateMediaSourceRequest preview;
    @Size(max = 128)
    String tagline;
    @Size(max = 128)
    String name;
    @Size(max = 128)
    String description;
    @Positive
    Integer ordinal;
    @Valid
    Set<CreateEpisodeRequest> episodes;
}