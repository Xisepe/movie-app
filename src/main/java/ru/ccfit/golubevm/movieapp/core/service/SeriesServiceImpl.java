package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ccfit.golubevm.movieapp.core.entity.*;
import ru.ccfit.golubevm.movieapp.core.exceptions.NotFoundException;
import ru.ccfit.golubevm.movieapp.core.exceptions.SeasonNotFoundException;
import ru.ccfit.golubevm.movieapp.core.exceptions.SeriesNotFoundException;
import ru.ccfit.golubevm.movieapp.core.mapper.SeriesMapper;
import ru.ccfit.golubevm.movieapp.core.repository.SeasonRepository;
import ru.ccfit.golubevm.movieapp.core.repository.SeriesRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {
    private final SeriesRepository seriesRepository;
    private final SpecService specService;
    private final SortService sortService;
    private final SeasonRepository seasonRepository;

    @Override
    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Transactional
    @Override
    public MediaSource createSeriesPreview(Integer seriesId, MediaSource mediaSource) {
        var series = getSeries(seriesId);
        series.setPreview(mediaSource);
        seriesRepository.save(series);
        return series.getPreview();
    }

    @Transactional
    @Override
    public Set<MediaSource> createSeriesMediaContent(Integer seriesId, Set<MediaSource> mediaSource) {
        var series = getSeries(seriesId);
        series.addMediaContent(mediaSource);
        seriesRepository.save(series);
        return series.getMediaContent();
    }

    @Transactional
    @Override
    public Set<TitleCrew> createSeriesTitleCrew(Integer seriesId, Set<TitleCrew> titleCrews) {
        var series = getSeries(seriesId);
        series.addTitleCrew(titleCrews);
        seriesRepository.save(series);
        return series.getTitleCrews();
    }

    @Transactional
    @Override
    public Set<TitleCast> createSeriesTitleCast(Integer seriesId, Set<TitleCast> titleCasts) {
        var series = getSeries(seriesId);
        series.addTitleCast(titleCasts);
        seriesRepository.save(series);
        return series.getTitleCasts();
    }

    @Transactional
    @Override
    public Set<Season> createSeason(Integer seriesId, Set<Season> seasons) {
        var series = getSeries(seriesId);
        series.addSeason(seasons);
        seriesRepository.save(series);
        return series.getSeasons();
    }

    @Transactional
    @Override
    public Set<Episode> createEpisode(Integer seriesId, Integer seasonId, Set<Episode> episodes) {
        var series = getSeries(seriesId);
        var season = seasonRepository.findById(seasonId).orElseThrow(() -> new SeasonNotFoundException(seasonId));
        season.addEpisode(episodes);
        seriesRepository.save(series);
        return season.getEpisodes();
    }

    @Override
    public Series getSeries(Integer id) {
        return seriesRepository.findById(id)
                .orElseThrow(() -> new SeriesNotFoundException(id));
    }

    @Override
    public Page<Series> getAllSeriesByFilterAndPageAndSort(String filter, int size, int page, String sort) {
        var spec = specService.buildSpecification(filter, Series.class);
        var srt = sortService.buildSort(sort);
        var pgReq = PageRequest.of(page, size, srt);
        return spec == null ? seriesRepository.findAll(pgReq) : seriesRepository.findAll(spec, pgReq);
    }

    @Override
    public Series updateSeries(Integer id, Series series) {
        Integer tId = null;
        if (seriesRepository.existsById(id)) {
            tId = id;
        }
        series.setId(tId);
        return seriesRepository.save(series);
    }

    @Override
    public void deleteSeries(Integer id) {

    }
}
