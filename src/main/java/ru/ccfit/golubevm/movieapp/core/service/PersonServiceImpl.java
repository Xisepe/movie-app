package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.exceptions.PersonNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public Person addCrewRole(Integer id, CrewRole crewRole) {
        var person = getPerson(id);
        person.getCrewRoles().add(crewRole);
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Integer id, Person person) {
        Integer tId = null;
        if (personRepository.existsById(id)) {
            person.setId(tId);
        }
        person.setId(null);
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
