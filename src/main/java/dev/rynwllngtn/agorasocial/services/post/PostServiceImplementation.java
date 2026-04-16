package dev.rynwllngtn.agorasocial.services.post;

import dev.rynwllngtn.agorasocial.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.entities.post.Post;
import dev.rynwllngtn.agorasocial.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasocial.mappers.post.PostMapper;
import dev.rynwllngtn.agorasocial.repositories.post.PostRepository;
import dev.rynwllngtn.agorasocial.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final ProfileService profileService;

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostReferenceDTO getReferenceById(String id) {
        Optional<PostReferenceDTO> postReferenceDTO = postRepository.getReferenceById(id);
        return postReferenceDTO.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostResponseDTO getResponseById(String id) {
        Optional<PostResponseDTO> postResponseDTO = postRepository.getResponseById(id);
        return postResponseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostResponseDTO insert(PostCreateRequestDTO createRequestDTO) {
        ProfileReferenceDTO referenceDTO = profileService.getReferenceById(createRequestDTO.author());
        Post post = postMapper.toEntity(createRequestDTO,
                                        referenceDTO);

        post = postRepository.save(post);
        return postMapper.toResponseDTO(post);
    }

}