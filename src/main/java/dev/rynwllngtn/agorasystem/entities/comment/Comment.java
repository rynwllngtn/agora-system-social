package dev.rynwllngtn.agorasystem.entities.comment;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentDTO;
import dev.rynwllngtn.agorasystem.dtos.comment.CommentPostDTO;
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
    private AuthorDTO author;
    private CommentPostDTO post;

    @CreatedDate
    private Instant date;
    private String body;

    public void update(CommentDTO commentDTO) {
        body = commentDTO.getBody();
    }

}