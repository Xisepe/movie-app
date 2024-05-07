package ru.ccfit.golubevm.movieapp.api.response;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;
import ru.ccfit.golubevm.movieapp.core.entity.MpaaRating;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Series}
 */
@Value
public class SlimSeriesResponse implements Serializable {
    MediaSourceResponse preview;
    Set<MediaSourceResponse> mediaContent;
    Integer id;
    String ruName;
    String enName;
    Set<SeriesTitleCrewResponse> titleCrews;
    Set<SeriesTitleCastResponse> titleCasts;
    String originalName;
    String tagline;
    LocalDate releaseDate;
    MpaaRating mpaaRating;
    Integer ageConstraint;
    Integer duration;
    CountryResponse originalCountry;
    Set<GenreResponse> genres;
    Set<Integer> seasonIds;
    @PositiveOrZero
    Integer totalSeason;
}