package ru.ccfit.golubevm.movieapp.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.exceptions.CrewRoleNotfoundException;
import ru.ccfit.golubevm.movieapp.core.repository.CrewRoleRepository;

@Service
@RequiredArgsConstructor
public class CrewRoleServiceImpl implements CrewRoleService {
    private final CrewRoleRepository crewRoleRepository;
    @Override
    public CrewRole getCrewRole(Integer id) {
        return crewRoleRepository.findById(id)
                .orElseThrow(()->new CrewRoleNotfoundException(id));
    }

    @Override
    public CrewRole createCrewRole(CrewRole crewRole) {
        return crewRoleRepository.save(crewRole);
    }

    @Override
    public CrewRole updateCrewRole(Integer id, CrewRole crewRole) {
        var role = getCrewRole(id);
        role.setName(crewRole.getName());
        return crewRoleRepository.save(crewRole);
    }

    @Override
    public void deleteCrewRole(Integer id) {
        crewRoleRepository.deleteById(id);
    }
}
