package ru.ccfit.golubevm.movieapp.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.response.CountryResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.CountryMapper;
import ru.ccfit.golubevm.movieapp.core.service.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    private final CountryMapper countryMapper;
    @GetMapping("/all")
    private List<CountryResponse> getAllCountries() {
        return countryService.getAllCountries()
                .stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    private CountryResponse getCountry(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name
    ) {
        return countryMapper.toDto(countryService.getByIdOrName(id, name));
    }

}
