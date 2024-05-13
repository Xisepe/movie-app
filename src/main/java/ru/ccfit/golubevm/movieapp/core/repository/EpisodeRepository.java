package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ccfit.golubevm.movieapp.core.entity.Episode;
import ru.ccfit.golubevm.movieapp.core.entity.TotalEpisodes;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query(value = "SELECT e.season.id as seasonId, COUNT(*) as totalEpisodes FROM Episode AS e GROUP BY e.season.id ORDER BY e.ordinal")
    List<TotalEpisodes> findTotalEpisodesBySeasonId(Integer seasonId);
}