package dev.rynwllngtn.agorasocial.services.post;

import dev.rynwllngtn.agorasocial.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasocial.entities.post.Post;

public interface PostService {

    Post findById(String id);
    PostReferenceDTO getReferenceById(String id);
    PostResponseDTO getResponseById(String id);

    PostResponseDTO insert(PostCreateRequestDTO createRequestDTO);

}