package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.post.PostRepository;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileService profileService;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public Post insert(Post post) {

        try {
            AuthorDTO author = profileService.findAuthorById(post.getAuthor().getId());
            post.setAuthor(author);
            post.setDate(new Date());
            postRepository.insert(post);
            return post;
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
    public Post update(String id, Post data) {
        Post post = findById(id);
        post.update(data);
        return postRepository.save(post);
    }

    @Override
    public List<ProfilePostDTO> findPostsByAuthorId(String id) {
        return postRepository.findPostsByAuthorId(id);
    }

}