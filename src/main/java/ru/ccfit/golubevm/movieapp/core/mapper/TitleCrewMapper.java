package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateTitleCrewRequest;
import ru.ccfit.golubevm.movieapp.api.response.SeriesTitleCrewResponse;
import ru.ccfit.golubevm.movieapp.api.response.TitleCrewPersonResponse;
import ru.ccfit.golubevm.movieapp.api.response.TitleCrewResponse;
import ru.ccfit.golubevm.movieapp.core.entity.TitleCrew;

import java.util.Set;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                CrewRoleMapper.class,
                TitleMapper.class,
                PersonMapper.class
        }
)
public interface TitleCrewMapper extends IdToReferenceMapper<Integer, TitleCrew> {
    TitleCrewPersonResponse toResponse(TitleCrew titleCrew);
    Set<TitleCrewPersonResponse> toTitleCrewPersonResponses(Set<TitleCrew> titleCrews);
    SeriesTitleCrewResponse toSeriesTitleCrewResponse(TitleCrew titleCrew);
    Set<SeriesTitleCrewResponse> toSeriesTitleCrewResponses(Set<TitleCrew> titleCrews);
    Set<TitleCrew> toEntities(Set<CreateTitleCrewRequest> requests);
    Set<TitleCrewResponse> toResponses(Set<TitleCrew> crews);
    TitleCrew toEntity(CreateTitleCrewRequest request);
}