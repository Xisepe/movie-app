package ru.ccfit.golubevm.movieapp;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Genre}
 */
@Value
public class CreateGenreRequest implements Serializable {
    @NotBlank
    String name;
}