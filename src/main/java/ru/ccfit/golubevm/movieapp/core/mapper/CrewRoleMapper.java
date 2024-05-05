package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.UpdateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.api.response.CrewRoleResponse;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CrewRoleMapper {
    CrewRole toEntity(CreateCrewRoleRequest createCrewRoleRequest);

    CreateCrewRoleRequest toDto(CrewRole crewRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CrewRole partialUpdate(CreateCrewRoleRequest createCrewRoleRequest, @MappingTarget CrewRole crewRole);

    CrewRole toEntity(CrewRoleResponse crewRoleResponse);

    CrewRoleResponse toDto1(CrewRole crewRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CrewRole partialUpdate(CrewRoleResponse crewRoleResponse, @MappingTarget CrewRole crewRole);

    CrewRole toEntity(UpdateCrewRoleRequest updateCrewRoleResponse);

    UpdateCrewRoleRequest toDto2(CrewRole crewRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CrewRole partialUpdate(UpdateCrewRoleRequest updateCrewRoleResponse, @MappingTarget CrewRole crewRole);
}