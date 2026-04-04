package dev.rynwllngtn.agorasystem.controllers.post;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable String id) {
        PostResponseDTO postResponseDTO = postService.findById(id);
        return ResponseEntity.ok().body(postResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> insert(@RequestBody PostCreateRequestDTO postCreateRequestDTO) {
        Post post = postService.insert(postCreateRequestDTO);
        PostResponseDTO postResponseDTO = new PostResponseDTO(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).body(postResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> update(@Valid @RequestBody PostUpdateRequestDTO postUpdateRequestDTO, @PathVariable String id) {
        Post post = postService.update(id, postUpdateRequestDTO);
        PostResponseDTO postResponseDTO = new PostResponseDTO(post);
        return ResponseEntity.ok().body(postResponseDTO);
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<CommentResponseDTO>> findAllComments(@PathVariable String id) {
        List<CommentResponseDTO> comments = commentService.findCommentsByPostId(id);
        return ResponseEntity.ok().body(comments);
    }

}