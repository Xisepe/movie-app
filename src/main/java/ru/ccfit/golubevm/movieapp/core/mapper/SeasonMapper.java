package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateSeasonRequest;
import ru.ccfit.golubevm.movieapp.api.response.SeasonResponse;
import ru.ccfit.golubevm.movieapp.api.response.SlimSeasonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Season;

import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                EpisodeMapper.class,
                MediaSourceMapper.class
        }
)
public interface SeasonMapper extends IdToReferenceMapper<Integer, Season> {
        SeasonResponse toSeasonResponse(Season season);
        SlimSeasonResponse toSlimSeasonResponse(Season season);
        Set<SlimSeasonResponse> toSlimSeasonResponses(Set<Season> seasons);

        Season toSeason(CreateSeasonRequest request);
        Set<Season> toSeasons(Set<CreateSeasonRequest> requests);
}
