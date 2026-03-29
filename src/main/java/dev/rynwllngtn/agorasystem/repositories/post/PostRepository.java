package dev.rynwllngtn.agorasystem.repositories.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}