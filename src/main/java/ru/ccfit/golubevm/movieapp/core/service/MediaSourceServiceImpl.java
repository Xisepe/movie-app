package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;
import ru.ccfit.golubevm.movieapp.core.exceptions.MediaSourceNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.MediaSourceRepository;

import java.net.URL;

@Service
@RequiredArgsConstructor
public class MediaSourceServiceImpl implements MediaSourceService {
    private final MediaSourceRepository mediaSourceRepository;
    @Override
    public MediaSource getMedia(Integer id) {
        return mediaSourceRepository
                .findById(id)
                .orElseThrow(() -> new MediaSourceNotFoundException(id));
    }

    @Override
    public MediaSource createMedia(MediaSource media) {
        return mediaSourceRepository.save(media);
    }

    @Override
    public void deleteMedia(Integer id) {
        mediaSourceRepository.deleteById(id);
    }

    @Override
    public MediaSource updateMedia(Integer id, MediaSource media) {
        if (!mediaSourceRepository.existsById(id)) {
            media.setId(null);
            return mediaSourceRepository.save(media);
        }
        media.setId(id);
        return mediaSourceRepository.save(media);
    }
}
