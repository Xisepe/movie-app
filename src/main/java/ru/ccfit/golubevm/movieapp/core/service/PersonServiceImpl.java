package ru.ccfit.golubevm.movieapp.core.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;
import ru.ccfit.golubevm.movieapp.core.entity.MediaType;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.repository.*;
import ru.ccfit.golubevm.movieapp.core.mapper.PersonMapper;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonMapper personMapper;
    private final CrewRoleRepository crewRoleRepository;
    private final CountryRepository countryRepository;

    @Transactional
    @Override
    public Person createPerson(CreatePersonRequest request) {
        var person = personMapper.createPersonRequestToPerson(request);
        var roles = request.getCrewRoleIds().stream()
                .map(crewRoleRepository::getReferenceById)
                .collect(Collectors.toSet());
        person.setCrewRoles(roles);
        if (request.getCountryId() != null) {
            var country = countryRepository.getReferenceById(request.getCountryId());
            person.setCitizenship(country);
        }
        if (request.getPreviewUrl() != null) {
            var mediaSource = new MediaSource();
            mediaSource.setMediaType(MediaType.PHOTO);
            mediaSource.setUrl(request.getPreviewUrl());
            person.setPreview(mediaSource);
        }

    }
}
