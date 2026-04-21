package dev.rynwllngtn.agorasocial.domain.post.controller;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Endpoints CRUD REST API para Post"
)
@RequestMapping(value = "/posts")
public interface PostControllerAPI {

    @Operation(
            summary = "Rota para leitura de Post pelo ID"
    )
    @GetMapping(value = "/{id}")
    ResponseEntity<PostResponseDTO> findById(@PathVariable String id);

    @Operation(
            summary = "Rota para criação de novo Post"
    )
    @PostMapping
    ResponseEntity<PostResponseDTO> insert(@Valid @RequestBody PostCreateRequestDTO createRequestDTO);

}