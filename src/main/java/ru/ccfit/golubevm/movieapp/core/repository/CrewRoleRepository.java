package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface CrewRoleRepository extends JpaRepository<CrewRole, Integer> {
    Set<CrewRole> findAllByIdIn(Collection<Integer> ids);
    Optional<CrewRole> findCrewRoleByName(String name);
}