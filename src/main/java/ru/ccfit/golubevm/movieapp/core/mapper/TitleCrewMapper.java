package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.response.TitleCrewPersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.TitleCrew;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CrewRoleMapper.class, TitleMapper.class}
)
public interface TitleCrewMapper extends IdToReferenceMapper<Integer, TitleCrew> {
    TitleCrew toEntity(TitleCrewPersonResponse titleCrewPersonResponse);

    TitleCrewPersonResponse toResponse(TitleCrew titleCrew);
}