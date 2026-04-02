package dev.rynwllngtn.agorasystem.repositories.post;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{ 'author._id' : ?0 }",
            fields = "{ '_id': 1, 'body':1 }")
    public List<ProfilePostDTO> findPostsByAuthorId(String id);

}