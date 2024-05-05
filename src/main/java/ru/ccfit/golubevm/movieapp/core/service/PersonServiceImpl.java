package ru.ccfit.golubevm.movieapp.core.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ccfit.golubevm.movieapp.core.entity.*;
import ru.ccfit.golubevm.movieapp.core.exceptions.NotFoundException;
import ru.ccfit.golubevm.movieapp.core.exceptions.PersonNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.PersonRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

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
