package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdatePersonRequest;
import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.PersonMapper;
import ru.ccfit.golubevm.movieapp.core.service.PersonService;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable Integer id) {
        return personMapper.toPersonResponse(personService.getPerson(id));
    }
    @PostMapping("/")
    public PersonResponse createPerson(@RequestBody @Valid CreatePersonRequest request) {
        var person = personMapper.toEntity(request);
        return personMapper.toPersonResponse(personService.createPerson(person));
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
    @PutMapping("/{id}")
    public PersonResponse updatePerson(@PathVariable Integer id, @RequestBody @Valid UpdatePersonRequest request) {
        var person = personMapper.toEntity(request);
        var response = personService.updatePerson(id, person);
        return personMapper.toPersonResponse(response);
    }
}
