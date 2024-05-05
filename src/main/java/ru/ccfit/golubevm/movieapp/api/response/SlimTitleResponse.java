package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Title}
 */
@Value
public class SlimTitleResponse implements Serializable {
    @NotNull
    Integer id;
    String ruName;
    String originalName;
}