package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "title_crew")
public class TitleCrew extends TitlePerson {

    @ManyToMany
    @JoinTable(
            name = "title_crew_role",
            joinColumns = {@JoinColumn(name = "title_crew_id")},
            inverseJoinColumns = {@JoinColumn(name = "crew_role_id")}
    )
    private Set<CrewRole> crewRoles = new LinkedHashSet<>();

}