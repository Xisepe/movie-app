package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.MediaSourceUpdate;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.MediaSourceMapper;
import ru.ccfit.golubevm.movieapp.core.service.MediaSourceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaSourceController {
    private final MediaSourceService mediaSourceService;
    private final MediaSourceMapper mediaSourceMapper;
    @GetMapping("/{id}")
    public MediaSourceResponse getMedia(@PathVariable @NotNull Integer id) {
        return mediaSourceMapper.mediaSourceToMediaSourceResponse(mediaSourceService.getMedia(id));
    }
    @PostMapping("/")
    public MediaSourceResponse createMedia(@Valid @RequestBody CreateMediaSourceRequest request) {
        var media = mediaSourceMapper.createMediaSourceRequestToMediaSource(request);
        return mediaSourceMapper.mediaSourceToMediaSourceResponse(
                mediaSourceService.createMedia(
                        media
                )
        );
    }
    @PutMapping("/{id}")
    public MediaSourceResponse updateMedia(@PathVariable Integer id, @RequestBody @Valid MediaSourceUpdate request) {
        var media = mediaSourceMapper.toEntity(request);
        return mediaSourceMapper.mediaSourceToMediaSourceResponse(mediaSourceService.updateMedia(id, media));
    }
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Integer id) {
        mediaSourceService.deleteMedia(id);
    }
}
