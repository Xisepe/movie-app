package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ccfit.golubevm.movieapp.api.request.CreateTitleCastRequest;
import ru.ccfit.golubevm.movieapp.api.response.SeriesTitleCrewResponse;
import ru.ccfit.golubevm.movieapp.api.response.SeriesTitleCastResponse;
import ru.ccfit.golubevm.movieapp.api.response.TitleCastPersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.TitleCast;

import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                TitleMapper.class,
                PersonMapper.class
        }
)
public interface TitleCastMapper extends IdToReferenceMapper<Integer, TitleCast> {
    TitleCastPersonResponse toResponse(TitleCast titleCast);
    Set<TitleCastPersonResponse> toTitleCastPersonResponses(Set<TitleCast> titleCasts);
    TitleCast toEntity(CreateTitleCastRequest dto);
    Set<TitleCast> toEntities(Set<CreateTitleCastRequest> dtos);
    SeriesTitleCrewResponse toSeriesTitleCrewResponse(TitleCast titleCast);
    Set<SeriesTitleCastResponse> toSeriesTitleCrewResponses(Set<TitleCast> titleCasts);
}