package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.movieapp.core.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}