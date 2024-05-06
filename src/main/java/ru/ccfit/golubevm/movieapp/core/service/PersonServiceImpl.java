package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ccfit.golubevm.movieapp.core.entity.*;
import ru.ccfit.golubevm.movieapp.core.exceptions.NoContentException;
import ru.ccfit.golubevm.movieapp.core.exceptions.PersonNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.PersonRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    private Person getPersonOrThrowNoContent(Integer id) {
        return personRepository.findById(id).orElseThrow(NoContentException::new);
    }

    @Override
    public List<Person> createPersons(List<Person> person) {
        return personRepository.saveAll(person);
    }

    @Override
    @Transactional
    public Person addCrewRole(Integer id, CrewRole crewRole) {
        var person = getPersonOrThrowNoContent(id);
        person.getCrewRoles().add(crewRole);
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public MediaSource updatePreview(Integer id, MediaSource mediaSource) {
        var person = getPersonOrThrowNoContent(id);
        person.setPreview(mediaSource);
        personRepository.save(person);
        return person.getPreview();
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Transactional
    @Override
    public Person updatePerson(Integer id, Person person) {
        if (!personRepository.existsById(id)) {
            throw new NoContentException();
        }
        person.setId(id);
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Set<TitleCast> getTitleCasts(Integer id) {
        var p = getPerson(id);
        return p.getTitleCasts();
    }

    @Transactional
    @Override
    public Set<TitleCrew> getTitleCrews(Integer id) {
        var p = getPerson(id);
        return p.getTitleCrews();
    }
}
