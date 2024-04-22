package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TitlePersonId implements Serializable {
    @Column(name = "title_id")
    private Integer titleId;

    @Column(name = "person_id")
    private Integer personId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TitlePersonId that = (TitlePersonId) o;
        return getTitleId() != null && Objects.equals(getTitleId(), that.getTitleId())
                && getPersonId() != null && Objects.equals(getPersonId(), that.getPersonId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(titleId, personId);
    }
}