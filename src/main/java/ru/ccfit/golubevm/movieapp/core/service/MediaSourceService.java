package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;

import java.net.URL;

public interface MediaSourceService {
    MediaSource getMedia(Integer id);
    MediaSource createMedia(CreateMediaSourceRequest request);
    void deleteMedia(Integer id);
    MediaSource updateMedia(MediaSourceResponse dto);
    MediaSource createWithUrl(URL url, MediaType mediaType);
}
