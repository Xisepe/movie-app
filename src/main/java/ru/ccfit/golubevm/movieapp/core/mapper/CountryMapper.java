package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.response.CountryResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Country;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReferenceMapper.class}
)
public interface CountryMapper extends IdToReferenceMapper<Integer, Country> {
    CountryResponse countryToCountryResponse(Country country);

    Country toEntity(CountryResponse countryResponse);
}