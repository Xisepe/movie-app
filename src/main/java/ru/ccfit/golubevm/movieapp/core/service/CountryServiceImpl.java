package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.core.entity.Country;
import ru.ccfit.golubevm.movieapp.core.entity.Film;
import ru.ccfit.golubevm.movieapp.core.entity.Series;
import ru.ccfit.golubevm.movieapp.core.exceptions.CountryNotFoundException;
import ru.ccfit.golubevm.movieapp.core.repository.CountryRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getByIdOrName(Integer id, String name) {
        if (id != null) {
            return getCountryById(id);
        } else {
            return getCountryByName(name);
        }
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository
                .findCountryByName(
                        name.toLowerCase()
                )
                .orElseThrow(() -> new CountryNotFoundException(name));
    }
}
