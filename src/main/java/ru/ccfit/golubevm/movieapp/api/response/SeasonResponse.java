package ru.ccfit.golubevm.movieapp.api.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Season}
 */
@Value
public class SeasonResponse implements Serializable {
    MediaSourceResponse preview;
    Integer id;
    String tagline;
    Integer totalVotes;
    Integer avgRating;
    String name;
    String description;
    Integer ordinal;
    Set<EpisodeResponse> episodes;
}