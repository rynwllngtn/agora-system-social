package dev.rynwllngtn.agorasystem.entities.comment;

import dev.rynwllngtn.agorasystem.dtos.comment.CommentUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Comment {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private ProfileReferenceDTO author;
    private PostReferenceDTO post;

    @CreatedDate
    private Instant date;
    private String body;

    public Comment(ProfileReferenceDTO author, PostReferenceDTO post, String body) {
        this.author = author;
        this.post = post;
        this.body = body;
    }

    public void update(CommentUpdateRequestDTO commentUpdateRequestDTO) {
        body = commentUpdateRequestDTO.getBody();
    }

}