package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.response.CountryResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Country;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {
    Country toEntity(CountryResponse countryResponse);

    CountryResponse toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryResponse countryResponse, @MappingTarget Country country);
}