package dev.rynwllngtn.agorasystem.dtos.profile;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfilePostDTO {

    private String id;
    private String body;

    public ProfilePostDTO(Post post) {
        id = post.getId();
        body = post.getBody();
    }

}