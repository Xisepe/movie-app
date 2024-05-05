package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.CrewRole}
 */
@Value
public class CreateCrewRoleRequest implements Serializable {
    @NotBlank
    String name;
}