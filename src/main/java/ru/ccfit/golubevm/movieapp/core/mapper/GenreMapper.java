package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.CreateGenreRequest;
import ru.ccfit.golubevm.movieapp.UpdateGenreRequest;
import ru.ccfit.golubevm.movieapp.api.response.GenreResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Genre;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {
    Genre toEntity(GenreResponse genreResponse);

    GenreResponse toDto(Genre genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(GenreResponse genreResponse, @MappingTarget Genre genre);

    Genre toEntity(CreateGenreRequest createGenreRequest);

    CreateGenreRequest toDto1(Genre genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(CreateGenreRequest createGenreRequest, @MappingTarget Genre genre);

    Genre toEntity(UpdateGenreRequest updateGenreRequest);

    UpdateGenreRequest toDto2(Genre genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(UpdateGenreRequest updateGenreRequest, @MappingTarget Genre genre);
}