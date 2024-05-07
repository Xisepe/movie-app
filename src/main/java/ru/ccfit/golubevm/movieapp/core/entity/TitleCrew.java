package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "title_crew")
public class TitleCrew extends TitlePerson {

    @ManyToMany
    @JoinTable(
            name = "title_crew_role",
            joinColumns = {@JoinColumn(name = "title_crew_id")},
            inverseJoinColumns = {@JoinColumn(name = "crew_role_id")}
    )
    @ToString.Exclude
    private Set<CrewRole> crewRoles = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    @ToString.Exclude
    private Title title;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TitleCrew titleCrew = (TitleCrew) o;
        return getId() != null && Objects.equals(getId(), titleCrew.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}