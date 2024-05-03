package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCast}
 */
@Value
public class PersonTitleCastDto implements Serializable {
    Integer id;
    Integer order;
    String characterName;
    PersonTitleDto title;
}