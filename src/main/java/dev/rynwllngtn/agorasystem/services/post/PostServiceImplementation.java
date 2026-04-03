package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
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
    public PostDTO findById(String id) {
        Optional<PostDTO> postDTO = postRepository.findPostById(id);
        return postDTO.orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public Post insert(Post post) {

        try {
            AuthorDTO author = profileService.findAuthorById(post.getAuthor().getId());
            post.setAuthor(author);
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
    public Post update(String id, PostDTO data) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
        post.update(data);
        return postRepository.save(post);
    }

    @Override
    public List<PostDTO> findPostsByAuthorId(String id) {
        return postRepository.findPostsByAuthorId(id);
    }

    @Override
    public CommentPostDTO findCommentPostById(String id) {
        return postRepository.findCommentPostById(id);
    }

}