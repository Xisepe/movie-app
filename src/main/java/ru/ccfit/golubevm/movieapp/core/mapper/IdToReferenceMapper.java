package ru.ccfit.golubevm.movieapp.core.mapper;

import java.util.List;
import java.util.Set;

public interface IdToReferenceMapper<ID,RefType> {
    RefType idToRef(ID id);
    Set<RefType> idsToRefs(Set<ID> ids);
}
