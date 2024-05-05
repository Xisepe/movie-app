package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateGenreRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdateGenreRequest;
import ru.ccfit.golubevm.movieapp.api.response.GenreResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.GenreMapper;
import ru.ccfit.golubevm.movieapp.core.service.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @GetMapping("/{id}")
    public GenreResponse getGenre(@PathVariable @NotNull Integer id) {
        return genreMapper.toResponse(genreService.getGenre(id));
    }

    @GetMapping("/")
    public List<GenreResponse> getAllGenres() {
        return genreService.getAllGenres().stream().map(genreMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping("/")
    public GenreResponse createGenre(@RequestBody @Valid CreateGenreRequest request) {
        var genre = genreMapper.toEntity(request);
        return genreMapper.toResponse(genreService.createGenre(genre));
    }

    @PutMapping("/{id}")
    public GenreResponse updateGenre(@PathVariable Integer id, @RequestBody @Valid UpdateGenreRequest request) {
        var genre = genreMapper.toEntity(request);
        return genreMapper.toResponse(genreService.updateGenre(id, genre));
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);
    }
}
