package dev.rynwllngtn.agorasystem.controllers.profile;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
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

    @GetMapping
    public ResponseEntity<List<Profile>> findAll() {
        List<Profile> profiles = profileService.findAll();
        return ResponseEntity.ok().body(profiles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile> findById(@PathVariable String id) {
        Profile profile = profileService.findById(id);
        return ResponseEntity.ok().body(profile);
    }

    @PostMapping
    public ResponseEntity<Profile> insert(@RequestBody Profile profile) {
        profile = profileService.insert(profile);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).body(profile);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profile> update(@RequestBody Profile profile, @PathVariable String id) {
        profile = profileService.update(id, profile);
        return ResponseEntity.ok().body(profile);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        Profile profile = profileService.findById(id);
        return ResponseEntity.ok().body(profile.getPosts());
    }

}