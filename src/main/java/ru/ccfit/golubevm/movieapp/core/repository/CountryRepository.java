package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.movieapp.core.entity.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findCountryByName(String name);
}