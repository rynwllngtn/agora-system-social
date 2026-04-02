package dev.rynwllngtn.agorasystem.repositories.profile;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileDTO;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'userName': 1, 'birthDate':1, 'active':1 }")
    public Optional<ProfileDTO> findProfileById(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 0, 'userName': 1 ")
    public Optional<AuthorDTO> findAuthorById(String id);

}