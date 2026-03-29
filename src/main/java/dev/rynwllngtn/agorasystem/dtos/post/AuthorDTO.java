package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO {

    private String id;
    private String userName;

    public AuthorDTO(Profile profile) {
        id = profile.getId();
        userName = profile.getUserName();
    }

}