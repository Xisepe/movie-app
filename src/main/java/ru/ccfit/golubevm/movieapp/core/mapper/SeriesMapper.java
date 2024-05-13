package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateSeriesRequest;
import ru.ccfit.golubevm.movieapp.api.response.SeriesResponse;
import ru.ccfit.golubevm.movieapp.api.response.SlimSeriesResponse;
import ru.ccfit.golubevm.movieapp.core.entity.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                TitleCrewMapper.class,
                TitleCastMapper.class,
                CountryMapper.class,
                GenreMapper.class,
                SeasonMapper.class,
                MediaSourceMapper.class
        }
)
public interface SeriesMapper extends IdToReferenceMapper<Integer, Series> {

    Series toSeries(CreateSeriesRequest dto);
    SlimSeriesResponse toSlimSeriesResponse(Series series);

    SeriesResponse toSeriesResponse(Series series);

}