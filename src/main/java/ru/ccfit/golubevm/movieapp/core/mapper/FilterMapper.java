package ru.ccfit.golubevm.movieapp.core.mapper;

import ru.ccfit.golubevm.movieapp.core.repository.Filter;

import java.util.List;

public interface FilterMapper {
    List<Filter> getFiltersFromString(String filter);
}
