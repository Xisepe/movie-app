package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;

public interface PersonService {
    Person createPerson(CreatePersonRequest request);
}
