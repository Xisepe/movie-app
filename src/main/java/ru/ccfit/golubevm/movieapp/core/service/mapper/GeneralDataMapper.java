package ru.ccfit.golubevm.movieapp.core.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.ccfit.golubevm.movieapp.api.CountryDto;
import ru.ccfit.golubevm.movieapp.api.CrewRoleDto;
import ru.ccfit.golubevm.movieapp.api.MediaSourceDto;
import ru.ccfit.golubevm.movieapp.core.entity.Country;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.entity.MediaSource;

@Mapper(componentModel = "spring")
public interface GeneralDataMapper {
    Country countryDtoToCountry(CountryDto countryDto);

    CountryDto countryToCountryDto(Country country);

    CrewRole crewRoleDtoToCrewRole(CrewRoleDto crewRoleDto);

    CrewRoleDto crewRoleToCrewRoleDto(CrewRole crewRole);

    MediaSource mediaSourceToMediaSourceDto(MediaSourceDto mediaSourceDto);

    MediaSourceDto mediaSourceDtoToMediaSource(MediaSource mediaSource);
}
