package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.response.TitleCastPersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.TitleCast;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TitleMapper.class}
)
public interface TitleCastMapper extends IdToReferenceMapper<Integer, TitleCast> {
    TitleCast toEntity(TitleCastPersonResponse titleCastPersonResponse);
    TitleCastPersonResponse toResponse(TitleCast titleCast);
}