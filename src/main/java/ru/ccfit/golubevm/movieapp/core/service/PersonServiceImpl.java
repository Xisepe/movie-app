package ru.ccfit.golubevm.movieapp.core.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;
import ru.ccfit.golubevm.movieapp.core.repository.*;
import ru.ccfit.golubevm.movieapp.core.service.mapper.PersonMapper;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;
    private final CrewRoleRepository crewRoleRepository;
    private final CountryRepository countryRepository;
    @Transactional
    @Override
    public PersonDto createPerson(CreatePersonRequest request) {
        var person = personMapper.createPersonRequestToPerson(request);
        var roles = crewRoleRepository.findAllByIdIn(request.getCrewRoleIds());
        person.setCrewRoles(roles);
        if (request.getCountryId() != null) {
            var country = countryRepository.findById(request.getCountryId()).orElseThrow();
            person.setCitizenship(country);
        }
        if (request.getPreviewUrl() != null) {
            var mediaSource = new MediaSource();
            mediaSource.setMediaType(MediaType.PHOTO);
            mediaSource.setUrl(request.getPreviewUrl());
            person.setPreview(mediaSource);
        }
        return personMapper.personToPersonDto(personRepository.save(person));
    }
}
