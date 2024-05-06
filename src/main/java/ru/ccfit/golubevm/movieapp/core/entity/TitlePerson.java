package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class TitlePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Positive
    @Column(name = "order", nullable = false)
    private Integer order;
}