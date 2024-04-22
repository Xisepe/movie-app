package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Episode extends MediaPreview {
    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

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
}