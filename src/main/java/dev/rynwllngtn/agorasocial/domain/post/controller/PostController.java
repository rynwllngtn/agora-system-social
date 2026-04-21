package dev.rynwllngtn.agorasocial.domain.post.controller;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import dev.rynwllngtn.agorasocial.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class PostController implements PostControllerAPI {

    private final PostService postService;

    @Override
    public ResponseEntity<PostResponseDTO> findById(String id) {
        PostResponseDTO responseDTO = postService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Override
    public ResponseEntity<PostResponseDTO> insert(PostCreateRequestDTO createRequestDTO) {
        PostResponseDTO responseDTO = postService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}