package ru.ccfit.golubevm.movieapp.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ccfit.golubevm.movieapp.api.request.CreateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.api.request.UpdateCrewRoleRequest;
import ru.ccfit.golubevm.movieapp.api.response.CrewRoleResponse;
import ru.ccfit.golubevm.movieapp.core.mapper.CrewRoleMapper;
import ru.ccfit.golubevm.movieapp.core.service.CrewRoleService;

@RestController
@RequestMapping("/crew-role")
@RequiredArgsConstructor
public class CrewRoleController {
    private final CrewRoleService crewRoleService;
    private final CrewRoleMapper crewRoleMapper;
    @GetMapping("/{id}")
    public CrewRoleResponse getCrewRole(@PathVariable Integer id) {
        return crewRoleMapper.toResponse(crewRoleService.getCrewRole(id));
    }
    @PostMapping("/")
    public CrewRoleResponse createCrewRole(@RequestBody @Valid CreateCrewRoleRequest request) {
        var role = crewRoleMapper.toEntity(request);
        return crewRoleMapper.toResponse(crewRoleService.createCrewRole(role));
    }
    @PutMapping("/{id}")
    public CrewRoleResponse updateCrewRole(@PathVariable Integer id, @RequestBody @Valid UpdateCrewRoleRequest request) {
        var role = crewRoleMapper.toEntity(request);
        return crewRoleMapper.toResponse(crewRoleService.updateCrewRole(id, role));
    }
    @DeleteMapping("/{id}")
    public void deleteCrewRole(@PathVariable Integer id) {
        crewRoleService.deleteCrewRole(id);
    }
}
