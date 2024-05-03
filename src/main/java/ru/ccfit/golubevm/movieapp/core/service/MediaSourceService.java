package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.MediaSourceDto;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

public interface MediaSourceService {
    MediaSource getMedia(Integer id);
    MediaSource createMedia(CreateMediaSourceRequest request);
    void deleteMedia(Integer id);
    MediaSource updateMedia(MediaSourceDto dto);
}
