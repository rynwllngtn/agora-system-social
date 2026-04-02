package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileDTO;
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
    public ProfileDTO findById(String id) {
        Optional<ProfileDTO> profileDTO = profileRepository.findProfileById(id);
        return profileDTO.orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public Profile insert(Profile profile) {

        try {
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
    public Profile update(String id, ProfileDTO profileDTO) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
        profile.update(profileDTO);
        return profileRepository.save(profile);
    }

    @Override
    public AuthorDTO findAuthorById(String id) {
        return profileRepository.findAuthorById(id).orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
    }

}