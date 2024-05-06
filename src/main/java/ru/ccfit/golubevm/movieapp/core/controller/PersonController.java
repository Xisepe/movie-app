package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdateMediaSourceRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdatePersonRequest;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.api.response.PersonResponse;
import ru.ccfit.golubevm.movieapp.api.response.TitleCastPersonResponse;
import ru.ccfit.golubevm.movieapp.api.response.TitleCrewPersonResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.*;
import ru.ccfit.golubevm.movieapp.core.service.PersonService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final CrewRoleMapper crewRoleMapper;
    private final MediaSourceMapper mediaSourceMapper;
    private final TitleCastMapper titleCastMapper;
    private final TitleCrewMapper titleCrewMapper;

    @PostMapping("/")
    public List<PersonResponse> createPersons(@RequestBody @Valid List<CreatePersonRequest> request) {
        var persons = personMapper.toEntities(request);
        return personMapper.toPersonResponses(personService.createPersons(persons));
    }

    @PostMapping("/{id}/roles")
    public PersonResponse addCrewRole(@PathVariable Integer id, @RequestParam("roleId") Integer roleId) {
        var crewRole = crewRoleMapper.idToRef(roleId);
        var person = personService.addCrewRole(id, crewRole);
        return personMapper.toPersonResponse(person);
    }

    @PutMapping("/{id}/preview")
    public MediaSourceResponse updatePreview(@PathVariable Integer id, @RequestBody @Valid UpdateMediaSourceRequest request) {
        var media = mediaSourceMapper.toEntity(request);
        return mediaSourceMapper.toResponse(personService.updatePreview(id, media));
    }

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable Integer id) {
        return personMapper.toPersonResponse(personService.getPerson(id));
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

    @GetMapping("/{id}/casts")
    public Set<TitleCastPersonResponse> getTitleCasts(@PathVariable Integer id) {
        return titleCastMapper.toTitleCastPersonResponses(personService.getTitleCasts(id));
    }

    @GetMapping("/{id}/crews")
    public Set<TitleCrewPersonResponse> getTitleCrews(@PathVariable Integer id) {
        return titleCrewMapper.toTitleCrewPersonResponses(personService.getTitleCrews(id));
    }
}
