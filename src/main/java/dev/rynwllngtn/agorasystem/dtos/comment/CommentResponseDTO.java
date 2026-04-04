package dev.rynwllngtn.agorasystem.dtos.comment;

import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDTO {

    private Instant date;
    private String body;

    public CommentResponseDTO(Comment comment) {
        date = comment.getDate();
        body = comment.getBody();
    }

}