package dev.rynwllngtn.agorasystem.dtos.comment;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentPostDTO {

    private String id;
    private String body;

    public CommentPostDTO(Post post) {
        id = post.getId();
        body = post.getBody();
    }

}
