package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "season")
public class Season extends SeriesUnit {
    @EmbeddedId
    private SeasonKey seasonKey;

    @ManyToMany
    @JoinTable(
            name = "season_episode",
            joinColumns = {
                    @JoinColumn(name="series_id"),
                    @JoinColumn(name = "ordinal")
            }
    )
    private Set<Episode> episodes = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Season season = (Season) o;
        return getSeasonKey() != null && Objects.equals(getSeasonKey(), season.getSeasonKey());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(seasonKey);
    }
}