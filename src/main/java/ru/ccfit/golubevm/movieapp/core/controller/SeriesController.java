package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.request.*;
import ru.ccfit.golubevm.movieapp.SeriesResponse;
import ru.ccfit.golubevm.movieapp.api.response.*;
import ru.ccfit.golubevm.movieapp.core.mapper.*;
import ru.ccfit.golubevm.movieapp.core.service.SeriesService;

import java.util.Set;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;
    private final SeriesMapper seriesMapper;
    private final SeasonMapper seasonMapper;
    private final MediaSourceMapper mediaSourceMapper;
    private final TitleCrewMapper titleCrewMapper;
    private final TitleCastMapper titleCastMapper;
    private final EpisodeMapper episodeMapper;

    @PostMapping("/")
    public SeriesResponse createSeries(@RequestBody @Valid CreateSeriesRequest request) {
        var series = seriesMapper.toSeries(request);
        return seriesMapper.toSeriesResponse(seriesService.createSeries(series));
    }

    @PostMapping("/{id}/preview")
    public MediaSourceResponse createSeriesPreview(@PathVariable Integer id, @RequestBody @Valid CreateMediaSourceRequest request) {
        var media = mediaSourceMapper.toEntity(request);
        return mediaSourceMapper.toResponse(seriesService.createSeriesPreview(id, media));
    }

    @PostMapping("/{id}/media")
    public Set<MediaSourceResponse> createSeriesMediaContent(
            @PathVariable Integer id,
            @RequestBody @Valid Set<CreateMediaSourceRequest> createMediaSourceRequests
    ) {
        var medias = mediaSourceMapper.toEntities(createMediaSourceRequests);
        return mediaSourceMapper.toResponses(seriesService.createSeriesMediaContent(id, medias));
    }

    @PostMapping("/{id}/crew")
    public Set<SeriesTitleCrewResponse> createSeriesTitleCrew(@PathVariable Integer id, @RequestBody @Valid Set<CreateTitleCrewRequest> request) {
        var crew = titleCrewMapper.toEntities(request);
        return titleCrewMapper.toSeriesTitleCrewResponses(seriesService.createSeriesTitleCrew(id, crew));
    }

    @PostMapping("/{id}/cast")
    public Set<SeriesTitleCastResponse> createSeriesTitleCast(@PathVariable Integer id, @RequestBody @Valid Set<CreateTitleCastRequest> requests) {
        var casts = titleCastMapper.toEntities(requests);
        return titleCastMapper.toSeriesTitleCrewResponses(seriesService.createSeriesTitleCast(id, casts));
    }

    @PostMapping("/{id}/season")
    public Set<SlimSeasonResponse> createSeriesSeason(@PathVariable Integer id, @RequestBody @Valid Set<CreateSeasonRequest> seasonRequests) {
        var seasons = seasonMapper.toSeasons(seasonRequests);
        var res = seriesService.createSeason(id, seasons);
        return seasonMapper.toSlimSeasonResponses(res);
    }

    @PostMapping("/{id}/season/{seasonId}/episode")
    public Set<SlimEpisodeResponse> createSeriesEpisode(
            @PathVariable Integer id,
            @PathVariable Integer seasonId,
            @RequestBody @Valid Set<CreateEpisodeRequest> requests
    ) {
        var episodes = episodeMapper.toEpisodes(requests);
        var res = seriesService.createEpisode(id, seasonId, episodes);
        return episodeMapper.toSlimEpisodeResponses(res);
    }

    @GetMapping("/{id}")
    public SlimSeriesResponse getSeries(@PathVariable Integer id) {
        return seriesMapper.toSlimSeriesResponse(seriesService.getSeries(id));
    }

    @GetMapping("/")
    public Page<SlimSeriesResponse> getAllSeriesByFilterPageSort(
            @RequestParam("filter") @Valid @Pattern(regexp = "(\\w+?)([:<=>]|<=|>=|!=)([\\w|-]+),?") String filter,
            @RequestParam("sort") @Valid @Pattern(regexp = "(\\w+?):(asc|desc),?") String sort,

            @RequestParam(value = "page", defaultValue = "0")
            @Valid @PositiveOrZero
            Integer page,

            @RequestParam(value = "size", defaultValue = "10")
            @Valid @Positive
            Integer size
    ) {
        var pages = seriesService.getAllSeriesByFilterAndPageAndSort(filter, size, page, sort);
        return pages.map(seriesMapper::toSlimSeriesResponse);
    }

    //    @GetMapping("/{id}/preview")
//    public MediaSourceResponse getPreview(@PathVariable Integer id) {
//
//    }
    @PutMapping("/{id}")
    public SeriesResponse updateSeries(@PathVariable Integer id) {
        return seriesMapper.toSeriesResponse(seriesService.updateSeries(id, null));
    }

    @DeleteMapping("/{id}")
    public void deleteSeries(@PathVariable Integer id) {
        seriesService.deleteSeries(id);
    }

}
