package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostCommentDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.comment.CommentRepository;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;

    @Override
    public CommentDTO findById(String id) {
        Optional<CommentDTO> commentDTO = commentRepository.findCommentById(id);
        return commentDTO.orElseThrow(() -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public Comment insert(Comment comment) {

        try {
            AuthorDTO author = profileService.findAuthorById(comment.getAuthor().getId());
            comment.setAuthor(author);
            CommentPostDTO post = postService.findCommentPostById(comment.getPost().getId());
            comment.setPost(post);
            return commentRepository.insert(comment);
        }
        catch (DuplicateKeyException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {

        if (!commentRepository.existsById(id)) {
            throw new ObjectNotFoundException(Comment.class, id);
        }

        commentRepository.deleteById(id);
    }

    @Override
    public Comment update(String id, CommentDTO data) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Comment.class, id));
        comment.update(data);
        return commentRepository.save(comment);
    }

    @Override
    public List<PostCommentDTO> findCommentsByPostId(String id) {
        return commentRepository.findCommentsByPostId(id);
    }

    @Override
    public List<CommentDTO> findCommentsByAuthorId(String id) {
        return commentRepository.findCommentsByAuthorId(id);
    }

}