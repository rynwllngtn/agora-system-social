package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public CommentResponseDTO findById(String id);

    public Comment insert(CommentCreateRequestDTO commentCreateRequestDTO);

    public void delete(String id);

    public Comment update(String id, CommentUpdateRequestDTO commentUpdateRequestDTO);

    public List<CommentResponseDTO> findCommentsByPostId(String id);

    public List<CommentResponseDTO> findCommentsByAuthorId(String id);

}