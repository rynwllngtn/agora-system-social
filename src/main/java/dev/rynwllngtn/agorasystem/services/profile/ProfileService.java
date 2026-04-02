package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {

    public ProfileDTO findById(String id);

    public Profile insert(Profile profile);

    public void delete(String id);

    public Profile update(String id, ProfileDTO profileDTO);

    public AuthorDTO findAuthorById(String id);

}