package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SeasonKey implements Serializable {
    @Column(name = "series_id")
    private Integer seriesId;
    @Column(name = "ordinal")
    private Integer ordinal;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SeasonKey seasonKey = (SeasonKey) o;
        return getSeriesId() != null && Objects.equals(getSeriesId(), seasonKey.getSeriesId())
                && getOrdinal() != null && Objects.equals(getOrdinal(), seasonKey.getOrdinal());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(seriesId, ordinal);
    }
}