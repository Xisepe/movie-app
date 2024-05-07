package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.UpdateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class}
)
public interface MediaSourceMapper extends IdToReferenceMapper<Integer, MediaSource> {
    MediaSource toEntity(CreateMediaSourceRequest request);

    MediaSourceResponse toResponse(MediaSource mediaSource);

    MediaSource toEntity(UpdateMediaSourceRequest updateMediaSourceRequest);

    MediaSource toEntity(MediaSourceResponse mediaSourceResponse);

    Set<MediaSource> toEntities(Set<CreateMediaSourceRequest> requests);
    Set<MediaSourceResponse> toResponses(Set<MediaSource> sources);
}
