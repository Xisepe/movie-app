package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "title")
@AssociationOverride(
        name = "mediaContent",
        joinTable = @JoinTable(
                name = "title_media_source",
                joinColumns = {@JoinColumn(name = "title_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "media_source_id", referencedColumnName = "id")}
        )
)
public class Title extends MediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ru_name")
    private String ruName;

    @Column(name = "en_name")
    private String enName;

    @OneToMany(mappedBy = "title", orphanRemoval = true)
    private Set<TitleCrew> titleCrews = new LinkedHashSet<>();

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private MpaaRating mpaaRating;

    @Column(name = "age_constraint")
    private Integer ageConstraint;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "original_country_id")
    private Country originalCountry;

    @ManyToMany
    @JoinTable(name = "title_genres",
            joinColumns = @JoinColumn(name = "title_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private Set<Genre> genres = new LinkedHashSet<>();

}