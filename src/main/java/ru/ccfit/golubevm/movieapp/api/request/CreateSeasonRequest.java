package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Season}
 */
@Value
public class CreateSeasonRequest implements Serializable {
    CreateMediaSourceRequest preview;
    String tagline;
    String name;
    String description;
    @Positive
    Integer ordinal;
    Set<CreateEpisodeRequest> episodes;
}