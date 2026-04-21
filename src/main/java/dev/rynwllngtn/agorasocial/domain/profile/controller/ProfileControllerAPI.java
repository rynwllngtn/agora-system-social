package dev.rynwllngtn.agorasocial.domain.profile.controller;

import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Endpoints CRUD REST API para Profile"
)
@RequestMapping(value = "/profiles")
public interface ProfileControllerAPI {

    @Operation(
            summary = "Rota para leitura de Profile pelo ID"
    )
    @GetMapping(value = "/{id}")
    ResponseEntity<ProfileResponseDTO> findById(@PathVariable String id);

    @Operation(
            summary = "Rota para criação de novo Profile"
    )
    @PostMapping
    ResponseEntity<ProfileResponseDTO> insert(@Valid @RequestBody ProfileCreateRequestDTO createRequestDTO);

}