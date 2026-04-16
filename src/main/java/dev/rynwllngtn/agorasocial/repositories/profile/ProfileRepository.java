package dev.rynwllngtn.agorasocial.repositories.profile;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.entities.profile.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'userName': 1, 'birthDate': 1, 'active': 1 }")
    Optional<ProfileResponseDTO> getResponseById(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 1, 'userName': 1 }")
    Optional<ProfileReferenceDTO> getReferenceById(String id);

}