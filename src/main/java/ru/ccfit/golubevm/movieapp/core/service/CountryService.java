package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.core.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getByIdOrName(Integer id, String name);
    Country getCountryById(Integer id);
    Country getCountryByName(String name);
}
