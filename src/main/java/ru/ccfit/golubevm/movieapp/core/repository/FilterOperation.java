package ru.ccfit.golubevm.movieapp.core.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum FilterOperation {
    GR(">"),
    GR_EQ(">="),
    LW("<"),
    LW_EQ("<="),
    EQ("="),
    NOT_EQ("!="),
    LIKE(":");
    private final String value;
    public static FilterOperation fromString(String value) {
        return Arrays.stream(FilterOperation.values())
                .filter(e->e.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
