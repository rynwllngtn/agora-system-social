package dev.rynwllngtn.agorasocial.domain.profile.controller;

import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.domain.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class ProfileController implements ProfileControllerAPI {

    private final ProfileService profileService;

    @Override
    public ResponseEntity<ProfileResponseDTO> findById(String id) {
        ProfileResponseDTO responseDTO = profileService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Override
    public ResponseEntity<ProfileResponseDTO> insert(ProfileCreateRequestDTO createRequestDTO) {
        ProfileResponseDTO responseDTO = profileService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}