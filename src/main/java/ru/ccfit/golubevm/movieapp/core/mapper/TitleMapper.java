package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.response.SlimTitleResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Title;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class}
)
public interface TitleMapper extends IdToReferenceMapper<Integer, Title> {
    Title toEntity(SlimTitleResponse slimTitleResponse);

    SlimTitleResponse toResponse(Title title);
}