package dev.rynwllngtn.agorasystem.entities.post;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
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
public class Post {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private AuthorDTO author;
    private Date date;
    private String title;
    private String body;

    public void update(Post data) {
        title = data.getTitle();
        body = data.getBody();
    }

}