package dev.rynwllngtn.agorasystem.dtos.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreateRequestDTO {

    private String author;
    private String post;
    private String body;

}