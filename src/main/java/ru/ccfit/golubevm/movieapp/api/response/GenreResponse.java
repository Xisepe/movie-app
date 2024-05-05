package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Genre}
 */
@Value
public class GenreResponse implements Serializable {
    @NotNull
    Integer id;
    @NotBlank
    String name;
}