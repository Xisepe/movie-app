package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "title_cast")
public class TitleCast extends TitlePerson {

    @Column(name = "character_name")
    private String characterName;

}