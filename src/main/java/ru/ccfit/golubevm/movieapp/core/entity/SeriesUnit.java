package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class SeriesUnit extends MediaPreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "total_votes")
    private Integer totalVotes;

    @Column(name = "avg_rating")
    private Integer avgRating;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "ordinal")
    private Integer ordinal;

}