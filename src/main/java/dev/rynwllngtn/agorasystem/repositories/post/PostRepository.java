package dev.rynwllngtn.agorasystem.repositories.post;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{ '_id': ?0 }", fields = "{ 'date': 1, 'title': 1, 'body': 1 }")
    public Optional<PostDTO> findPostById(String id);

    @Query(value = "{ 'author._id' : ?0 }", fields = "{ 'date': 1, 'title': 1, 'body': 1 }")
    public List<PostDTO> findPostsByAuthorId(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 1, 'body': 1 }")
    public CommentPostDTO findCommentPostById(String id);

}