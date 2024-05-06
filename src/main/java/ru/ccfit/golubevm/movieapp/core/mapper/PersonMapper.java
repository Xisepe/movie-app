package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.request.*;
import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Person;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class,
                MediaSourceMapper.class,
                CountryMapper.class,
                CrewRoleMapper.class
        }
)
public interface PersonMapper {
    @Mapping(source = "citizenshipId", target = "citizenship")
    @Mapping(source = "preview", target = "preview")
    @Mapping(source = "crewRoleIds", target = "crewRoles")
    Person toEntity(CreatePersonRequest request);
    @Mapping(source = "preview", target = "preview")
    @Mapping(source = "citizenshipId", target = "citizenship")
    @Mapping(source = "crewRoleIds", target = "crewRoles")
    Person toEntity(UpdatePersonRequest updatePersonRequest);
    List<Person> toEntities(List<CreatePersonRequest> request);
    PersonResponse toPersonResponse(Person person);
    List<PersonResponse> toPersonResponses(List<Person> personList);
    SlimPersonResponse toSlimPersonResponse(Person person);
}