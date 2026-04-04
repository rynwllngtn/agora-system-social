package dev.rynwllngtn.agorasystem.repositories.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query(value = "{ '_id': ?0 }", fields = "{ 'date': 1, 'body': 1 }")
    public Optional<CommentResponseDTO> findCommentById(String id);

    @Query(value = "{ 'post._id' : ?0 }", fields = "{ 'date': 1, 'body': 1 }")
    public List<CommentResponseDTO> findCommentsByPostId(String id);

    @Query(value = "{ 'author._id' : ?0 }", fields = "{ 'date': 1, 'body': 1 }")
    public List<CommentResponseDTO> findCommentsByAuthorId(String id);

}