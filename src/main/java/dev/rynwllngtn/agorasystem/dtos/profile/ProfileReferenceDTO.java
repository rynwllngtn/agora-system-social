package dev.rynwllngtn.agorasystem.dtos.profile;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileReferenceDTO {

    private String id;
    private String userName;

    public ProfileReferenceDTO(Profile profile) {
        id = profile.getId();
        userName = profile.getUserName();
    }

}