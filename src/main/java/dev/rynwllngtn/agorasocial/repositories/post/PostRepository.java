package dev.rynwllngtn.agorasocial.repositories.post;

import dev.rynwllngtn.agorasocial.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasocial.entities.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'date': 1, 'title': 1, 'body': 1 }")
    Optional<PostResponseDTO> getResponseById(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 1, 'body': 1 }")
    Optional<PostReferenceDTO> getReferenceById(String id);

}