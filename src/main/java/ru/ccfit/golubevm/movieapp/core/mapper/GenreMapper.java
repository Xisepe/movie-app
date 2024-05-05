package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateGenreRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdateGenreRequest;
import ru.ccfit.golubevm.movieapp.api.response.GenreResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Genre;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class}
)
public interface GenreMapper extends IdToReferenceMapper<Integer, Genre> {
    GenreResponse toResponse(Genre genre);
    Genre toEntity(CreateGenreRequest createGenreRequest);
    Genre toEntity(UpdateGenreRequest updateGenreRequest);
}