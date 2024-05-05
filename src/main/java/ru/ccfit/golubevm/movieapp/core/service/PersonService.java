package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Person;

public interface PersonService {
    Person getPerson(Integer id);
    Person createPerson(Person person);
    Person updatePerson(Integer id, Person person);
    void deletePerson(Integer id);
}
