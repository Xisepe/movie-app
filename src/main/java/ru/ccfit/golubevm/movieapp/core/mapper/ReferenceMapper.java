package ru.ccfit.golubevm.movieapp.core.mapper;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class ReferenceMapper {
    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T> T map(@NonNull final Integer id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }
}
