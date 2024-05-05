package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PersonMapper {
    @Autowired
    protected GeneralDataMapper generalDataMapper;

    public abstract Person createPersonRequestToPerson(CreatePersonRequest request);
    public abstract PersonDto personToPersonDto(Person person);

}
