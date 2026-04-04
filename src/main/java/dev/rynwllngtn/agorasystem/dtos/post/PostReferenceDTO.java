package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReferenceDTO {

    private String id;
    private String body;

    public PostReferenceDTO(Post post) {
        id = post.getId();
        body = post.getBody();
    }

}
