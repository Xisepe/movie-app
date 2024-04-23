package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EpisodeKey implements Serializable {
    @Column(name = "season_id")
    private Integer seasonId;
    @Column(name = "ordinal")
    private Integer ordinal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EpisodeKey entity = (EpisodeKey) o;
        return Objects.equals(this.seasonId, entity.seasonId) &&
                Objects.equals(this.ordinal, entity.ordinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, ordinal);
    }
}