package dev.rynwllngtn.agorasocial.mappers.post;

import dev.rynwllngtn.agorasocial.dtos.post.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.dtos.post.PostResponseDTO;
import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.entities.post.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostResponseDTO toResponseDTO(Post post) {
        return new PostResponseDTO(post.getId(),
                                   post.getDate(),
                                   post.getTitle(),
                                   post.getBody());
    }

    public Post toEntity(PostCreateRequestDTO createRequestDTO, ProfileReferenceDTO author) {
        return new Post(author,
                        createRequestDTO.title(),
                        createRequestDTO.body());
    }

}