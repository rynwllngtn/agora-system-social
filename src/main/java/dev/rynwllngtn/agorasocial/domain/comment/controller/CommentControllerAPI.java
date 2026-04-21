package dev.rynwllngtn.agorasocial.domain.comment.controller;

import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Endpoints CRUD REST API para Comment"
)
@RequestMapping(value = "/comments")
public interface CommentControllerAPI {

    @Operation(
            summary = "Rota para leitura de Comment pelo ID"
    )
    @GetMapping(value = "/{id}")
    ResponseEntity<CommentResponseDTO> findById(@PathVariable String id);

    @Operation(
            summary = "Rota para criação de novo Comment"
    )
    @PostMapping
    ResponseEntity<CommentResponseDTO> insert(@Valid @RequestBody CommentCreateRequestDTO createRequestDTO);

}