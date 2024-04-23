package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@MappedSuperclass
public abstract class MediaEntity extends MediaPreview {
    @ManyToMany
    protected Set<MediaSource> mediaContent;
}
