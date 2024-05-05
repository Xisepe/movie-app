package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.response.GenreResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre getGenre(Integer id);
    List<Genre> getAllGenres();
    Genre createGenre(Genre genre);
    Genre updateGenre(Integer id, Genre genre);
    void deleteGenre(Integer id);
}
