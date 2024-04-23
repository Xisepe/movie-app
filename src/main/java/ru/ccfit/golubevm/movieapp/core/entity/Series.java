package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Series extends Title {
    @ManyToMany
    private Set<Season> seasons = new LinkedHashSet<>();
}