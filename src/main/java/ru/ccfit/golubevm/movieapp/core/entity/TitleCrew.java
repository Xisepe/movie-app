package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "title_crew")
public class TitleCrew extends TitlePerson {

    @ManyToMany
    private Set<CrewRole> crewRoles = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TitleCrew titleCrew = (TitleCrew) o;
        return getTitlePersonId() != null && Objects.equals(getTitlePersonId(), titleCrew.getTitlePersonId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getTitlePersonId());
    }
}