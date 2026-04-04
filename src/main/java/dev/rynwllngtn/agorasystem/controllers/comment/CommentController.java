package dev.rynwllngtn.agorasystem.controllers.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable String id) {
        CommentResponseDTO commentResponseDTO = commentService.findById(id);
        return ResponseEntity.ok().body(commentResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> insert(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO) {
        Comment comment = commentService.insert(commentCreateRequestDTO);
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(uri).body(commentResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDTO> update(@RequestBody CommentUpdateRequestDTO commentUpdateRequestDTO, @PathVariable String id) {
        Comment comment = commentService.update(id, commentUpdateRequestDTO);
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO(comment);
        return ResponseEntity.ok().body(commentResponseDTO);
    }

}