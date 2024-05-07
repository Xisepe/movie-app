package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.Positive;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.request.SlimPersonResponse;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCast}
 */
@Value
public class SeriesTitleCastResponse implements Serializable {
    Integer id;
    @Positive
    Integer order;
    String characterName;
    SlimPersonResponse person;
}