package ru.ccfit.golubevm.movieapp.core.service.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@RequiredArgsConstructor
public abstract class PersonMapper {
    protected final GeneralDataMapper generalDataMapper;

    public abstract Person createPersonRequestToPerson(CreatePersonRequest request);
    public abstract PersonDto personToPersonDto(Person person);

}
