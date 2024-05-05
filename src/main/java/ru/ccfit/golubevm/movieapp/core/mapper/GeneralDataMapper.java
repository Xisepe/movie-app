package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.*;
import ru.ccfit.golubevm.movieapp.api.CountryDto;
import ru.ccfit.golubevm.movieapp.api.CrewRoleDto;
import ru.ccfit.golubevm.movieapp.api.response.MediaSourceResponse;
import ru.ccfit.golubevm.movieapp.core.entity.Country;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

@Mapper(componentModel = "spring")
public interface GeneralDataMapper {
    Country countryDtoToCountry(CountryDto countryDto);

    CountryDto countryToCountryDto(Country country);

    CrewRole crewRoleDtoToCrewRole(CrewRoleDto crewRoleDto);

    CrewRoleDto crewRoleToCrewRoleDto(CrewRole crewRole);

    MediaSource mediaSourceToMediaSourceDto(MediaSourceResponse mediaSourceResponse);

    MediaSourceResponse mediaSourceToMediaSourceDto(MediaSource mediaSource);
}
