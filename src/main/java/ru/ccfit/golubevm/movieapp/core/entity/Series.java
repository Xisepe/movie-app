package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Series extends Title {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "series_id")
    @OrderBy("ordinal asc")
    private Set<Season> seasons = new LinkedHashSet<>();

    @Column(name = "total_season", nullable = false)
    @PositiveOrZero
    Integer totalSeason = 0;

    public void addSeason(Set<Season> seasons) {
        this.seasons.addAll(seasons);
    }


}