package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class EpisodeId {
    @Column(name = "title_id")
    private Integer titleId;
    @Column(name = "episode_number")

}