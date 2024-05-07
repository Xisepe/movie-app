package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Episode}
 */
@Value
public class CreateEpisodeRequest implements Serializable {
    CreateMediaSourceRequest preview;
    String tagline;
    String name;
    String description;
    @Positive
    Integer ordinal;
}