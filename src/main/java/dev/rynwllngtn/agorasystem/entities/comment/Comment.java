package dev.rynwllngtn.agorasystem.entities.comment;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private ProfilePostDTO post;
    private Date date;
    private String body;

    public void update(Comment data) {
        body = data.getBody();
    }

}