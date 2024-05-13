package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Episode}
 */
@Value
public class CreateEpisodeRequest implements Serializable {
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
}