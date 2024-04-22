package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class MediaPreview {
    @ManyToOne
    @JoinColumn(name = "preview_id")
    protected MediaSource preview;
}
