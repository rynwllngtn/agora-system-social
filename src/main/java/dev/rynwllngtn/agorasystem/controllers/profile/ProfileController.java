package dev.rynwllngtn.agorasystem.controllers.profile;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfileDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable String id) {
        ProfileDTO profileDTO = profileService.findById(id);
        return ResponseEntity.ok().body(profileDTO);
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> insert(@RequestBody Profile profile) {
        profileService.insert(profile);
        ProfileDTO profileDTO = new ProfileDTO(profile);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).body(profileDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfileDTO> update(@RequestBody ProfileDTO profileDTO, @PathVariable String id) {
        profileService.update(id, profileDTO);
        return ResponseEntity.ok().body(profileDTO);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<ProfilePostDTO>> findAllPosts(@PathVariable String id) {
        List<ProfilePostDTO> posts = postService.findPostsByAuthorId(id);
        return ResponseEntity.ok().body(posts);
    }

}