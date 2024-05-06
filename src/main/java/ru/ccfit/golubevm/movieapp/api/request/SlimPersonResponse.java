package ru.ccfit.golubevm.movieapp.api.request;

import lombok.Value;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Person}
 */
@Value
public class SlimPersonResponse implements Serializable {
    MediaSourceResponse preview;
    Integer id;
    String name;
}