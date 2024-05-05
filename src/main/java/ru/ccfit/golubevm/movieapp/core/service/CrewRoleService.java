package ru.ccfit.golubevm.movieapp.core.service;

import ru.ccfit.golubevm.movieapp.api.CrewRoleDto;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;

import java.util.List;

public interface CrewRoleService {
    CrewRole createCrewRole(CreateCrewRoleRequest dto);
    CrewRole getCrewRoleById(Integer id);
    CrewRole findCrewRoleByName(String name);
    List<CrewRole> getAllCrewRoles();
    void deleteCrewRole(Integer id);
}
