package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;

import java.io.Serializable;
import java.net.URL;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.MediaSource}
 */
@Value
public class MediaSourceDto implements Serializable {
    Integer id;
    URL url;
    MediaType mediaType;
}