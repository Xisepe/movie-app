package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.movieapp.core.entity.Genre;

import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Set<Genre> findAllByIdIn(Set<Integer> ids);
}