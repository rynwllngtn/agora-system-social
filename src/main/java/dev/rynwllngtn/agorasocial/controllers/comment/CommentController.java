package dev.rynwllngtn.agorasocial.controllers.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.services.comment.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/comments")
@Tag(
        name = "Endpoints CRUD REST API para Comment"
)
public class CommentController {

    private final CommentService commentService;

    @Operation(
            summary = "Rota para leitura de Comment pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable String id) {
        CommentResponseDTO commentResponseDTO = commentService.getResponseById(id);
        return ResponseEntity.ok().body(commentResponseDTO);
    }

    @Operation(
            summary = "Rota para criação de novo Comment"
    )
    @PostMapping
    public ResponseEntity<CommentResponseDTO> insert(@Valid @RequestBody CommentCreateRequestDTO createRequestDTO) {
        CommentResponseDTO responseDTO = commentService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}