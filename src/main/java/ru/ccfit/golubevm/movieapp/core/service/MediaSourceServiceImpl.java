package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.api.MediaSourceDto;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;
import ru.ccfit.golubevm.movieapp.core.repository.MediaSourceRepository;

@Service
@RequiredArgsConstructor
public class MediaSourceServiceImpl implements MediaSourceService {
    private final MediaSourceRepository mediaSourceRepository;
    @Override
    public MediaSource getMedia(Integer id) {
        //todo
        return mediaSourceRepository.findById(id).orElseThrow();
    }

    @Override
    public MediaSource createMedia(CreateMediaSourceRequest request) {
        var media = new MediaSource();
        media.setMediaType(request.getMediaType());
        media.setUrl(request.getUrl());
        mediaSourceRepository.save(media);
        return media;
    }

    @Override
    public void deleteMedia(Integer id) {
        mediaSourceRepository.deleteById(id);
    }

    @Override
    public MediaSource updateMedia(MediaSourceDto dto) {
        var media = mediaSourceRepository.getReferenceById(dto.getId());
        media.setUrl(dto.getUrl());
        media.setMediaType(dto.getMediaType());
        mediaSourceRepository.save(media);
        return media;
    }
}
