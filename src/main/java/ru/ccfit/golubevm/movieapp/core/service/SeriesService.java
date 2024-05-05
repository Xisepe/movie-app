package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.core.entity.Episode;
import ru.ccfit.golubevm.movieapp.core.entity.Season;
import ru.ccfit.golubevm.movieapp.core.entity.Series;

import java.util.List;
import java.util.Set;

public interface SeriesService {
    Series getSeries(Integer id);
    Series createSeries(Series series);
    Series updateSeries(Integer id, Series series);
    void deleteSeries(Integer id);
    Set<Season> getAllSeasons(Integer seriesId);
    Season getSeason(Integer seriesId, Integer seasonOrder);
    Season createSeason(Integer seriesId, Season season);
    Season updateSeason(Integer seriesId, Season season);
    void deleteSeason(Integer seasonId);
    Set<Episode> getAllEpisodesBySeason(Integer seriesId, Integer seasonOrder);
    Episode getEpisode(Integer seriesId, Integer seasonOrder, Integer episodeOrder);
    Episode createEpisode(Integer seriesId, Integer seasonOrder, Episode episode);
    Episode updateEpisode(Integer seriesId, Integer seasonOrder, Episode episode);
    void deleteEpisode(Integer seriesId, Integer seasonOrder, Integer episodeOrder);


}
