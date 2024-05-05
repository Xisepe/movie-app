package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.Mapper;
import ru.ccfit.golubevm.movieapp.api.request.MediaSourceUpdate;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

@Mapper(componentModel = "spring")
public interface MediaSourceMapper {
    MediaSource createMediaSourceRequestToMediaSource(CreateMediaSourceRequest request);

    MediaSourceResponse mediaSourceToMediaSourceResponse(MediaSource mediaSource);

    MediaSource toEntity(MediaSourceUpdate mediaSourceUpdate);

    MediaSourceUpdate toDto(MediaSource mediaSource);
}
