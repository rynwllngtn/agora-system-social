package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {

    public ProfileResponseDTO findById(String id);

    public Profile insert(ProfileCreateRequestDTO profileCreateRequestDTO);

    public void delete(String id);

    public Profile update(String id, ProfileUpdateRequestDTO profileUpdateRequestDTO);

    public AuthorDTO findAuthorById(String id);

}