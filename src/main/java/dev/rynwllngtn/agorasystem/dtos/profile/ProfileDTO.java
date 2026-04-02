package dev.rynwllngtn.agorasystem.dtos.profile;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private String userName;
    private Date birthDate;
    private boolean active;

    public ProfileDTO(Profile profile) {
        userName = profile.getUserName();
        birthDate = profile.getBirthDate();
        active = profile.isActive();
    }

}