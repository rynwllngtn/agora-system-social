package dev.rynwllngtn.agorasocial.controllers.profile;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.services.profile.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(@PathVariable String id) {
        ProfileResponseDTO responseDTO = profileService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> insert(@Valid @RequestBody ProfileCreateRequestDTO createRequestDTO) {
        ProfileResponseDTO responseDTO = profileService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}