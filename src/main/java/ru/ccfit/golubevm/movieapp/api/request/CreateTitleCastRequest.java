package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCast}
 */
@Value
public class CreateTitleCastRequest implements Serializable {
    @Positive
    Integer order;
    String characterName;
    Integer personId;
    Integer titleId;
}