package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;

import java.io.Serializable;
import java.net.URL;

@Value
public class CreateMediaSourceRequest implements Serializable {
    @NotNull
    URL url;
    @NotNull
    MediaType mediaType;
}
