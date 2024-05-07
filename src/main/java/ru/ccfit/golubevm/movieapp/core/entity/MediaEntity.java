package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@MappedSuperclass
public abstract class MediaEntity extends MediaPreview {
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    protected Set<MediaSource> mediaContent;
}
