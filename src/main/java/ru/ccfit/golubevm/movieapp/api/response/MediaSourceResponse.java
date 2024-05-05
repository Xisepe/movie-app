package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;

import java.io.Serializable;
import java.net.URL;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.MediaSource}
 */
@Value
public class MediaSourceResponse implements Serializable {
    @NotNull
    Integer id;
    @NotNull
    URL url;
    @NotNull
    MediaType mediaType;
}