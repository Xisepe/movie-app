package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.core.entity.Genre;
import ru.ccfit.golubevm.movieapp.core.exceptions.GenreNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre getGenre(Integer id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Integer id, Genre genre) {
        Integer tId = null;
        if (genreRepository.existsById(id)) {
            tId = id;
        }
        genre.setId(tId);
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
