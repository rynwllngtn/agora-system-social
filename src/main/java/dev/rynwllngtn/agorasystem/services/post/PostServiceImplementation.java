package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.post.PostRepository;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileService profileService;

    @Override
    public PostResponseDTO findById(String id) {
        Optional<PostResponseDTO> postDTO = postRepository.findPostById(id);
        return postDTO.orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public Post insert(PostCreateRequestDTO postCreateRequestDTO) {

        try {
            ProfileReferenceDTO author = profileService.findReferenceById(postCreateRequestDTO.getAuthor());
            Post post = new Post(author,
                                 postCreateRequestDTO.getTitle(),
                                 postCreateRequestDTO.getBody());

            return postRepository.insert(post);
        }
        catch (DuplicateKeyException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {

        if (!postRepository.existsById(id)) {
            throw new ObjectNotFoundException(Post.class, id);
        }

        postRepository.deleteById(id);
    }

    @Override
    public Post update(String id, PostUpdateRequestDTO postUpdateRequestDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
        post.update(postUpdateRequestDTO);
        return postRepository.save(post);
    }

    @Override
    public List<PostResponseDTO> findPostsByAuthorId(String id) {
        return postRepository.findPostsByAuthorId(id);
    }

    @Override
    public PostReferenceDTO findReferenceById(String id) {
        return postRepository.findReferenceById(id).orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
    }

}