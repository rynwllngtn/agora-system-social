package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostCommentDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public CommentDTO findById(String id);

    public Comment insert(Comment comment);

    public void delete(String id);

    public Comment update(String id, CommentDTO commentDTO);

    public List<PostCommentDTO> findCommentsByPostId(String id);

    public List<CommentDTO> findCommentsByAuthorId(String id);

}