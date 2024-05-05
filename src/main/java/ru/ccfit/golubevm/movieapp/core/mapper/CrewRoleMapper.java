package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.UpdateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.api.response.CrewRoleResponse;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class}
)
public interface CrewRoleMapper extends IdToReferenceMapper<Integer, CrewRole> {
    CrewRole toEntity(CreateCrewRoleRequest createCrewRoleRequest);

    CrewRoleResponse toResponse(CrewRole crewRole);

    CrewRole toEntity(UpdateCrewRoleRequest updateCrewRoleResponse);
}