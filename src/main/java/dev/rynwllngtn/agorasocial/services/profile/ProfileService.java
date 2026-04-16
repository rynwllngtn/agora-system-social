package dev.rynwllngtn.agorasocial.services.profile;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.entities.profile.Profile;

public interface ProfileService {

    Profile findById(String id);
    ProfileReferenceDTO getReferenceById(String id);
    ProfileResponseDTO getResponseById(String id);

    ProfileResponseDTO insert(ProfileCreateRequestDTO createRequestDTO);

}