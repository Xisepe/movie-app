package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateEpisodeRequest;
import ru.ccfit.golubevm.movieapp.api.response.EpisodeResponse;
import ru.ccfit.golubevm.movieapp.api.response.SlimEpisodeResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Episode;

import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class, MediaSourceMapper.class}
)
public interface EpisodeMapper extends IdToReferenceMapper<Integer, Episode> {
    EpisodeResponse toEpisodeResponse(Episode episode);
    Episode toEpisode(CreateEpisodeRequest episodeRequest);
    Set<Episode> toEpisodes(Set<CreateEpisodeRequest> episodeRequests);
    SlimEpisodeResponse toSlimEpisodeResponse(Episode episode);
    Set<SlimEpisodeResponse> toSlimEpisodeResponses(Set<Episode> episodes);
}
