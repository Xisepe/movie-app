package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.repository.CrewRoleRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CrewRoleServiceImpl implements CrewRoleService {
    private final CrewRoleRepository crewRoleRepository;
    @Override
    public CrewRole createCrewRole(CreateCrewRoleRequest dto) {
        var role = new CrewRole();
        role.setName(dto.getName());
        crewRoleRepository.save(role);
        return role;
    }

    @Override
    public CrewRole getCrewRoleById(Integer id) {
        //todo
        return crewRoleRepository.findById(id).orElseThrow();
    }

    @Override
    public CrewRole findCrewRoleByName(String name) {
        return crewRoleRepository.findCrewRoleByName(name).orElseThrow();
    }

    @Override
    public List<CrewRole> getAllCrewRoles() {
        return crewRoleRepository.findAll();
    }
}
