package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.UpdatePersonRequest;
import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.Person;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                MediaSourceMapper.class,
                CountryMapper.class,
                CrewRoleMapper.class,
                TitleCastMapper.class,
                TitleCrewMapper.class
        }
)
public interface PersonMapper {
    @Mapping(source = "previewId", target = "preview")
    @Mapping(source = "citizenshipId", target = "citizenship")
    @Mapping(source = "crewRoleIds", target = "crewRoles")
    @Mapping(source = "titleCastIds", target = "titleCasts")
    @Mapping(source = "titleCrewIds", target = "titleCrews")
    Person toEntity(CreatePersonRequest createPersonRequest);
    PersonResponse toPersonResponse(Person person);
    @Mapping(source = "previewId", target = "preview")
    @Mapping(source = "citizenshipId", target = "citizenship")
    @Mapping(source = "crewRoleIds", target = "crewRoles")
    @Mapping(source = "titleCastIds", target = "titleCasts")
    @Mapping(source = "titleCrewIds", target = "titleCrews")
    Person toEntity(UpdatePersonRequest updatePersonRequest);

}