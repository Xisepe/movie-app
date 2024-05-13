package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;

import java.io.Serializable;
import java.net.URL;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.MediaSource}
 */
@Value
public class CreateMediaSourceRequest implements Serializable {
    @NotNull
    URL url;
    @NotNull
    @Valid
    MediaType mediaType;
}
