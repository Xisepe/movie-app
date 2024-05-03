package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.MediaSourceDto;
import ru.ccfit.golubevm.movieapp.api.request.CreateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.core.service.MediaSourceService;
import ru.ccfit.golubevm.movieapp.core.service.mapper.GeneralDataMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaSourceController {
    private final MediaSourceService mediaSourceService;
    private final GeneralDataMapper generalDataMapper;

    @GetMapping("/{id}")
    public MediaSourceDto getMedia(@PathVariable Integer id) {
        return generalDataMapper.mediaSourceDtoToMediaSource(mediaSourceService.getMedia(id));
    }
    @PostMapping("/")
    public MediaSourceDto createMedia(@Valid @RequestBody CreateMediaSourceRequest request) {
        return generalDataMapper.mediaSourceDtoToMediaSource(mediaSourceService.createMedia(request));
    }
    @PutMapping("/")
    public MediaSourceDto updateMedia(@Valid @RequestBody MediaSourceDto request) {
        return generalDataMapper.mediaSourceDtoToMediaSource(mediaSourceService.updateMedia(request));
    }
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Integer id) {
        mediaSourceService.deleteMedia(id);
    }
}
