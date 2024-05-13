package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class SlimPersonResponse implements Serializable {
    @Valid
    MediaSourceResponse preview;
    @Positive
    Integer id;
    @Size(max = 128)
    String name;
}