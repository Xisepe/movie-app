package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class TitlePerson {
    @EmbeddedId
    private TitlePersonId titlePersonId;

    @ManyToOne
    @MapsId("titleId")
    @JoinColumn(name = "title_id")
    private Title title;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "order")
    private Integer order;
}