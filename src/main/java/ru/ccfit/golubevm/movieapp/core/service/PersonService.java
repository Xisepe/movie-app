package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;

public interface PersonService {
    PersonDto createPerson(CreatePersonRequest request);
}
