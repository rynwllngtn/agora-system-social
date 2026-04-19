package dev.rynwllngtn.agorasocial.entities.post;

import dev.rynwllngtn.agorasocial.dtos.profile.ProfileReferenceDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "posts")
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

}