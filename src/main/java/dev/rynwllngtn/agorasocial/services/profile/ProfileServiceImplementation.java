package dev.rynwllngtn.agorasocial.services.profile;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.entities.profile.Profile;
import dev.rynwllngtn.agorasocial.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasocial.mappers.profile.ProfileMapper;
import dev.rynwllngtn.agorasocial.repositories.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileServiceImplementation implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Profile findById(String id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileReferenceDTO getReferenceById(String id) {
        Optional<ProfileReferenceDTO> profileReferenceDTO = profileRepository.getReferenceById(id);
        return profileReferenceDTO.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileResponseDTO getResponseById(String id) {
        Optional<ProfileResponseDTO> profileResponseDTO = profileRepository.getResponseById(id);
        return profileResponseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileResponseDTO insert(ProfileCreateRequestDTO createRequestDTO) {
        Profile profile = profileMapper.toEntity(createRequestDTO);
        profile = profileRepository.save(profile);
        return profileMapper.toResponseDTO(profile);
    }

}