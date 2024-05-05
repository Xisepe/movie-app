package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.CreateSeriesRequest;
import ru.ccfit.golubevm.movieapp.core.entity.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                TitleCrewMapper.class,
                TitleCastMapper.class,
                CountryMapper.class,
                GenreMapper.class,
                SeasonMapper.class
        }
)
public interface SeriesMapper extends IdToReferenceMapper<Integer, Series> {
    @Mapping(source = "titleCrewIds", target = "titleCrews")
    @Mapping(source = "titleCastIds", target = "titleCasts")
    @Mapping(source = "originalCountryId", target = "originalCountry")
    @Mapping(source = "genreIds", target = "genres")
    @Mapping(source = "seasonIds", target = "seasons")
    Series toEntity(CreateSeriesRequest dto);

}