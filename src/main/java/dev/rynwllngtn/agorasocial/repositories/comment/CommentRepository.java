package dev.rynwllngtn.agorasocial.repositories.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.entities.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query(value = "{ '_id': ?0 }", fields = "{ 'date': 1, 'body': 1 }")
    Optional<CommentResponseDTO> getResponseById(String id);

}