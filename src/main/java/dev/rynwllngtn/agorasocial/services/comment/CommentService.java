package dev.rynwllngtn.agorasocial.services.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.entities.comment.Comment;

public interface CommentService {

    Comment findById(String id);
    CommentResponseDTO getResponseById(String id);

    CommentResponseDTO insert(CommentCreateRequestDTO createRequestDTO);

}