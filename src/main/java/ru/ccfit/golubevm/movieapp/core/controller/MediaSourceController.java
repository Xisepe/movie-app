package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
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
    public MediaSourceResponse getMedia(@PathVariable Integer id) {
        return generalDataMapper.mediaSourceToMediaSourceDto(mediaSourceService.getMedia(id));
    }
    @PostMapping("/")
    public MediaSourceResponse createMedia(@Valid @RequestBody CreateMediaSourceRequest request) {
        return generalDataMapper.mediaSourceToMediaSourceDto(mediaSourceService.createMedia(request));
    }
    @PutMapping("/")
    public MediaSourceResponse updateMedia(@Valid @RequestBody MediaSourceResponse request) {
        return generalDataMapper.mediaSourceToMediaSourceDto(mediaSourceService.updateMedia(request));
    }
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Integer id) {
        mediaSourceService.deleteMedia(id);
    }
}
