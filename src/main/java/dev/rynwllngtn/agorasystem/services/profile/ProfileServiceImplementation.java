package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileResponseDTO findById(String id) {
        Optional<ProfileResponseDTO> profileResponseDTO = profileRepository.findProfileById(id);
        return profileResponseDTO.orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public Profile insert(ProfileCreateRequestDTO profileCreateRequestDTO) {

        try {
            Profile profile = new Profile(profileCreateRequestDTO.getProfileOwner(),
                                          profileCreateRequestDTO.getUserName(),
                                          profileCreateRequestDTO.getBirthDate());

            return profileRepository.insert(profile);
        }
        catch (DuplicateKeyException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {

        if (!profileRepository.existsById(id)) {
            throw new ObjectNotFoundException(Profile.class, id);
        }

        profileRepository.deleteById(id);
    }

    @Override
    public Profile update(String id, ProfileUpdateRequestDTO profileUpdateRequestDTO) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
        profile.update(profileUpdateRequestDTO);
        return profileRepository.save(profile);
    }

    @Override
    public ProfileReferenceDTO findReferenceById(String id) {
        return profileRepository.findReferenceById(id).orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
    }

}