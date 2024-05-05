package ru.ccfit.golubevm.movieapp.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.CountryDto;
import ru.ccfit.golubevm.movieapp.core.service.CountryService;
import ru.ccfit.golubevm.movieapp.core.mapper.GeneralDataMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    private final GeneralDataMapper generalDataMapper;
    @GetMapping("/all")
    private List<CountryDto> getAllCountries() {
        return countryService.getAllCountries()
                .stream()
                .map(generalDataMapper::countryToCountryDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
    }

    @GetMapping("/")
    private CountryDto getCountry(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name
    ) {
        return generalDataMapper.countryToCountryDto(countryService.getByIdOrName(id, name));
    }

}
