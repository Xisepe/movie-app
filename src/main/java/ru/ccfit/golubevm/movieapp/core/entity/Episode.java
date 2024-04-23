package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "episode")
public class Episode extends SeriesUnit {

    @EmbeddedId
    private EpisodeKey episodeKey;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Episode episode = (Episode) o;
        return getEpisodeKey() != null && Objects.equals(getEpisodeKey(), episode.getEpisodeKey());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getEpisodeKey());
    }
}