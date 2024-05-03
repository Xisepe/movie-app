package ru.ccfit.golubevm.movieapp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class MediaPreview {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preview_id")
    protected MediaSource preview;
}
