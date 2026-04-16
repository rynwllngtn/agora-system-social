package dev.rynwllngtn.agorasocial.controllers.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.services.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable String id) {
        CommentResponseDTO commentResponseDTO = commentService.getResponseById(id);
        return ResponseEntity.ok().body(commentResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> insert(@RequestBody CommentCreateRequestDTO createRequestDTO) {
        CommentResponseDTO responseDTO = commentService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}