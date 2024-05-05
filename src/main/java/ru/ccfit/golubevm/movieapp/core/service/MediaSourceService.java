package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

public interface MediaSourceService {
    MediaSource getMedia(Integer id);
    MediaSource createMedia(MediaSource media);
    MediaSource updateMedia(Integer id, MediaSource media);
    void deleteMedia(Integer id);
}
