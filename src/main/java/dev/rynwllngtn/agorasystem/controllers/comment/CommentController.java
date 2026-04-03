package dev.rynwllngtn.agorasystem.controllers.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String id) {
        CommentDTO commentDTO = commentService.findById(id);
        return ResponseEntity.ok().body(commentDTO);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> insert(@RequestBody Comment comment) {
        comment = commentService.insert(comment);
        CommentDTO commentDTO = new CommentDTO(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(uri).body(commentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> update(@RequestBody CommentDTO commentDTO, @PathVariable String id) {
        commentService.update(id, commentDTO);
        return ResponseEntity.ok().body(commentDTO);
    }

}