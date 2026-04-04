package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
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
    public CommentResponseDTO findById(String id) {
        Optional<CommentResponseDTO> commentDTO = commentRepository.findCommentById(id);
        return commentDTO.orElseThrow(() -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public Comment insert(CommentCreateRequestDTO commentCreateRequestDTO) {

        try {
            ProfileReferenceDTO profileReferenceDTO = profileService.findReferenceById(commentCreateRequestDTO.getAuthor());
            PostReferenceDTO postReferenceDTO = postService.findReferenceById(commentCreateRequestDTO.getPost());
            Comment comment = new Comment(profileReferenceDTO,
                                  postReferenceDTO,
                                  commentCreateRequestDTO.getBody());

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
    public Comment update(String id, CommentUpdateRequestDTO commentUpdateRequestDTO) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Comment.class, id));
        comment.update(commentUpdateRequestDTO);
        return commentRepository.save(comment);
    }

    @Override
    public List<CommentResponseDTO> findCommentsByPostId(String id) {
        return commentRepository.findCommentsByPostId(id);
    }

    @Override
    public List<CommentResponseDTO> findCommentsByAuthorId(String id) {
        return commentRepository.findCommentsByAuthorId(id);
    }

}