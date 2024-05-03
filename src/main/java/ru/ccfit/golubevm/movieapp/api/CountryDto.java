package ru.ccfit.golubevm.movieapp.api;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.ccfit.golubevm.movieapp.core.entity.Country}
 */
@Value
public class CountryDto implements Serializable {
    Integer id;
    String alpha2;
    String alpha3;
    String name;
}