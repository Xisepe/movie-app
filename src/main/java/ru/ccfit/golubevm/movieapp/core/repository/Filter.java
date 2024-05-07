package ru.ccfit.golubevm.movieapp.core.repository;

import lombok.Data;

@Data
public class Filter {
    private final String key;
    private final FilterOperation operation;
    private final String value;
}
