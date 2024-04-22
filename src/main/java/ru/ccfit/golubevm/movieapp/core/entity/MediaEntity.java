package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

import java.util.Set;

@MappedSuperclass
public abstract class MediaEntity extends MediaPreview {
    @ManyToMany
    private Set<MediaSource> mediaContent;
}
