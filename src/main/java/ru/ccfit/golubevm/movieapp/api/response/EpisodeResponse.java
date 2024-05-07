package ru.ccfit.golubevm.movieapp.api.response;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Episode}
 */
@Value
public class EpisodeResponse implements Serializable {
    MediaSourceResponse preview;
    Integer id;
    String tagline;
    Integer totalVotes;
    Integer avgRating;
    String name;
    String description;
    Integer ordinal;
}