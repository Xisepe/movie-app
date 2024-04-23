package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "alpha_2", nullable = false, length = 2)
    private String alpha2;

    @Column(name = "alpha_3", nullable = false, length = 3)
    private String alpha3;

    @Column(name = "name", nullable = false, length = 75)
    private String name;

}