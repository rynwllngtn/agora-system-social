package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public PostResponseDTO findById(String id);

    public Post insert(PostCreateRequestDTO postCreateRequestDTO);

    public void delete(String id);

    public Post update(String id, PostUpdateRequestDTO postUpdateRequestDTO);

    public List<PostResponseDTO> findPostsByAuthorId(String id);

    public PostReferenceDTO findReferenceById(String id);

}