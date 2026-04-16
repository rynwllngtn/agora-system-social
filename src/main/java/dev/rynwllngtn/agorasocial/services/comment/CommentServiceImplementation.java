package dev.rynwllngtn.agorasocial.services.comment;

import dev.rynwllngtn.agorasocial.dtos.comment.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.comment.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.entities.comment.Comment;
import dev.rynwllngtn.agorasocial.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasocial.mappers.comment.CommentMapper;
import dev.rynwllngtn.agorasocial.repositories.comment.CommentRepository;
import dev.rynwllngtn.agorasocial.services.post.PostService;
import dev.rynwllngtn.agorasocial.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    private final ProfileService profileService;
    private final PostService postService;

    @Override
    public Comment findById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(
                () -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public CommentResponseDTO getResponseById(String id) {
        Optional<CommentResponseDTO> responseDTO = commentRepository.getResponseById(id);
        return responseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public CommentResponseDTO insert(CommentCreateRequestDTO createRequestDTO) {
        ProfileReferenceDTO profileReferenceDTO = profileService.getReferenceById(createRequestDTO.author());
        PostReferenceDTO postReferenceDTO = postService.getReferenceById(createRequestDTO.post());
        Comment comment = commentMapper.toEntity(createRequestDTO,
                                                 profileReferenceDTO,
                                                 postReferenceDTO);

        comment = commentRepository.save(comment);
        return commentMapper.toResponseDTO(comment);
    }

}