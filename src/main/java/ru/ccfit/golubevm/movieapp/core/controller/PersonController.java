package ru.ccfit.golubevm.movieapp.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ccfit.golubevm.movieapp.api.request.CreatePersonRequest;
import ru.ccfit.golubevm.movieapp.core.entity.PersonDto;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @PostMapping("/")
    public PersonDto createPerson(@RequestBody CreatePersonRequest request) {

    }

}
