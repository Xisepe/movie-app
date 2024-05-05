package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;

public interface CrewRoleService {
    CrewRole getCrewRole(Integer id);
    CrewRole createCrewRole(CrewRole crewRole);
    CrewRole updateCrewRole(Integer id, CrewRole crewRole);
    void deleteCrewRole(Integer id);
}
