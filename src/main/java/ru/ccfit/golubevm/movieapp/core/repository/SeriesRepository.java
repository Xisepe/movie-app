package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.ccfit.golubevm.movieapp.core.entity.Series;
public interface SeriesRepository extends JpaRepository<Series, Integer>, JpaSpecificationExecutor<Series> {
}