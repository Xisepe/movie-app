package ru.ccfit.golubevm.movieapp.core.service;

import org.springframework.data.domain.Sort;

public interface SortService {
    Sort buildSort(String sort);
}
