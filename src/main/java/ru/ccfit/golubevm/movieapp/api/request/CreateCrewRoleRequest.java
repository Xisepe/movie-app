package ru.ccfit.golubevm.movieapp.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

@Value
public class CreateCrewRoleRequest implements Serializable {
    @NotBlank
    String name;
}
