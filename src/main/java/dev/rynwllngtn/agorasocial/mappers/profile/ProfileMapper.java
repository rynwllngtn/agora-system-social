package dev.rynwllngtn.agorasocial.mappers.profile;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.entities.profile.Profile;

public class ProfileMapper {

    public ProfileResponseDTO toResponseDTO(Profile profile) {
        return new ProfileResponseDTO(profile.getId(),
                                      profile.getUserName(),
                                      profile.getBirthDate(),
                                      profile.isActive());
    }

    public Profile toEntity(ProfileCreateRequestDTO createRequestDTO) {
        return new Profile(createRequestDTO.profileOwner(),
                           createRequestDTO.userName(),
                           createRequestDTO.birthDate());
    }

}