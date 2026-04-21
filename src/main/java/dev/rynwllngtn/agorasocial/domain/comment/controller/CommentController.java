package dev.rynwllngtn.agorasocial.domain.comment.controller;

import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class CommentController implements CommentControllerAPI {

    private final CommentService commentService;

    @Override
    public ResponseEntity<CommentResponseDTO> findById(String id) {
        CommentResponseDTO commentResponseDTO = commentService.getResponseById(id);
        return ResponseEntity.ok().body(commentResponseDTO);
    }

    @Override
    public ResponseEntity<CommentResponseDTO> insert(CommentCreateRequestDTO createRequestDTO) {
        CommentResponseDTO responseDTO = commentService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}