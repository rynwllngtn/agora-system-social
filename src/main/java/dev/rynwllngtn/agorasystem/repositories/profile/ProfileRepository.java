package dev.rynwllngtn.agorasystem.repositories.profile;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'userName': 1, 'birthDate': 1, 'active': 1 }")
    public Optional<ProfileResponseDTO> findProfileById(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 1, 'userName': 1 }")
    public Optional<ProfileReferenceDTO> findReferenceById(String id);

}