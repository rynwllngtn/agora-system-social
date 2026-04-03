package dev.rynwllngtn.agorasystem.controllers.profile;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(@PathVariable String id) {
        ProfileResponseDTO profileResponseDTO = profileService.findById(id);
        return ResponseEntity.ok().body(profileResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> insert(@RequestBody ProfileCreateRequestDTO profileCreateRequestDTO) {
        Profile profile = profileService.insert(profileCreateRequestDTO);
        ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO(profile);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).body(profileResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfileResponseDTO> update(@Valid @RequestBody ProfileUpdateRequestDTO profileUpdateRequestDTO, @PathVariable String id) {
        Profile profile = profileService.update(id, profileUpdateRequestDTO);
        ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO(profile);
        return ResponseEntity.ok().body(profileResponseDTO);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostDTO>> findAllPosts(@PathVariable String id) {
        List<PostDTO> posts = postService.findPostsByAuthorId(id);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<CommentDTO>> findAllComments(@PathVariable String id) {
        List<CommentDTO> comments = commentService.findCommentsByAuthorId(id);
        return ResponseEntity.ok().body(comments);
    }

}