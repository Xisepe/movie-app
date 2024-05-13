package ru.ccfit.golubevm.movieapp.core.service;

import org.springframework.data.domain.Page;
import ru.ccfit.golubevm.movieapp.core.entity.*;

import java.util.List;
import java.util.Set;

public interface SeriesService {
    Series createSeries(Series series);
    MediaSource createSeriesPreview(Integer seriesId, MediaSource mediaSource);
    Set<MediaSource> createSeriesMediaContent(Integer seriesId, Set<MediaSource> mediaSource);
    Set<TitleCrew> createSeriesTitleCrew(Integer seriesId, Set<TitleCrew> titleCrews);
    Set<TitleCast> createSeriesTitleCast(Integer seriesId, Set<TitleCast> titleCasts);
    Set<Season> createSeason(Integer seriesId, Set<Season> seasons);
    Set<Episode> createEpisode(Integer seriesId, Integer seasonId, Set<Episode> episodes);

    Series getSeries(Integer id);
    Set<Season> getSeasons(Integer id);
    Season getSeason(Integer id, Integer seasonId);
//    Set<Episode> getEpisodes(Integer id, Integer seasonId);
//    Episode getEpisode(Integer id, Integer seasonId, Integer episodeId);
//    Set<MediaSource> getMediaContent(Integer id);
//    MediaSource getPreview(Integer id);

    void deleteSeries(Integer id);
//    void deleteSeasons(Integer id);
//    void deleteSeason(Integer id, Integer seasonId);
//    void deleteEpisodes(Integer id, Integer seasonId);
//    void deleteEpisode(Integer id, Integer seasonId, Integer episodeId);
//    void deletePreview(Integer id);
//    void deleteMediaContent(Integer id);
//    void deleteMediaContent(Integer id, Integer mediaSourceId);


    Page<Series> getAllSeriesByFilterAndPageAndSort(String filter, int size, int page, String sort);
//    MediaSource getPreview(Integer id);
//    Set<MediaSource> getContent(Integer id);
//    Set<TitleCrew> getTitleCrew(Integer id);
//    Set<TitleCast> getTitleCast(Integer id);
//    Set<Season> getSeasons(Integer id);
//    Season getSeason(Integer id, Integer seasonId);
//    Set<Episode> getEpisodes(Integer id, Integer seasonId);
//    Episode getEpisode(Integer id, Integer seasonId, Integer episodeId);

    Series updateSeries(Integer id, Series series);

}
