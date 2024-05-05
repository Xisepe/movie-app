package ru.ccfit.golubevm.movieapp.api.response;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.TitleCast}
 */
@Value
public class TitleCastPersonResponse implements Serializable {
    Integer id;
    String characterName;
    SlimTitleResponse title;
}