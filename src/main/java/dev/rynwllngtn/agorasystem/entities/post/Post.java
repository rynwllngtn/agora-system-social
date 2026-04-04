package dev.rynwllngtn.agorasystem.entities.post;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfileReferenceDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostUpdateRequestDTO;
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
public class Post {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private ProfileReferenceDTO author;

    @CreatedDate
    private Instant date;
    private String title;
    private String body;

    public Post(ProfileReferenceDTO author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public void update(PostUpdateRequestDTO postUpdateRequestDTO) {
        title = postUpdateRequestDTO.getTitle();
        body = postUpdateRequestDTO.getBody();
    }

}