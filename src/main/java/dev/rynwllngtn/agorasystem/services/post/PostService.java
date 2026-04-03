package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public PostDTO findById(String id);

    public Post insert(Post post);

    public void delete(String id);

    public Post update(String id, PostDTO postDTO);

    public List<ProfilePostDTO> findPostsByAuthorId(String id);

    public CommentPostDTO findCommentPostById(String id);

}