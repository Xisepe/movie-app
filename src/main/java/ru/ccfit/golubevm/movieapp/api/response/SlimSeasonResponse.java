package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.Positive;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Season}
 */
@Value
public class SlimSeasonResponse implements Serializable {
    CreateMediaSourceRequest preview;
    Integer id;
    String name;
    @Positive
    Integer ordinal;
    Set<SlimEpisodeResponse> episodes;
}