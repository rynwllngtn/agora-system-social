package dev.rynwllngtn.agorasocial.mappers.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.entities.comment.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentResponseDTO toResponseDTO(Comment comment) {
        return new CommentResponseDTO(comment.getId(),
                                      comment.getDate(),
                                      comment.getBody());
    }

    public Comment toEntity(CommentCreateRequestDTO createRequestDTO,
                            ProfileReferenceDTO author,
                            PostReferenceDTO post) {

        return new Comment(author,
                           post,
                           createRequestDTO.body());
    }

}