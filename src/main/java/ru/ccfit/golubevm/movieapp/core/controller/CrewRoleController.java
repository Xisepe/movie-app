package ru.ccfit.golubevm.movieapp.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.CrewRoleDto;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.core.service.CrewRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/crew-role")
@RequiredArgsConstructor
public class CrewRoleController {
    private final CrewRoleService crewRoleService;
    private final GeneralDataMapper generalDataMapper;

    @PostMapping("/")
    public CrewRoleDto createCrewRole(@RequestBody CreateCrewRoleRequest request) {
        return generalDataMapper.crewRoleToCrewRoleDto(crewRoleService.createCrewRole(request));
    }
    @GetMapping("/{id}")
    public CrewRoleDto getCrewRoleById(@PathVariable("id") Integer id) {
        return generalDataMapper.crewRoleToCrewRoleDto(crewRoleService.getCrewRoleById(id));
    }
    @GetMapping("/")
    public List<CrewRoleDto> getAll() {
        return crewRoleService
                .getAllCrewRoles()
                .stream()
                .map(generalDataMapper::crewRoleToCrewRoleDto)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void deleteCrewRole(@PathVariable("id") Integer id) {
        crewRoleService.deleteCrewRole(id);
    }
}
