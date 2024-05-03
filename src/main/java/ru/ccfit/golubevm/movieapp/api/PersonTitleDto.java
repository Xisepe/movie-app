package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Title}
 */
@Value
public class PersonTitleDto implements Serializable {
    MediaSourceDto preview;
    Integer id;
    String ruName;
    String enName;
}