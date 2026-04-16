package dev.rynwllngtn.agorasocial.controllers.post;

import dev.rynwllngtn.agorasocial.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasocial.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable String id) {
        PostResponseDTO responseDTO = postService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> insert(@RequestBody PostCreateRequestDTO createRequestDTO) {
        PostResponseDTO responseDTO = postService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}