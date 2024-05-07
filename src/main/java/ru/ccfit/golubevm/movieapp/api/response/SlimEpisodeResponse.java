package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Episode}
 */
@Value
public class SlimEpisodeResponse implements Serializable {
    MediaSourceResponse preview;
    Integer id;
    String name;
    @Positive
    Integer ordinal;
}