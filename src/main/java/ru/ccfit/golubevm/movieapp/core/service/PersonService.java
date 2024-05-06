package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.core.entity.*;

import java.util.List;
import java.util.Set;

public interface PersonService {
    List<Person> createPersons(List<Person> person);
    Person addCrewRole(Integer id, CrewRole crewRole);
    MediaSource updatePreview(Integer id, MediaSource mediaSource);
    Person getPerson(Integer id);
    Person updatePerson(Integer id, Person person);
    void deletePerson(Integer id);
    Set<TitleCast> getTitleCasts(Integer id);
    Set<TitleCrew> getTitleCrews(Integer id);
}
