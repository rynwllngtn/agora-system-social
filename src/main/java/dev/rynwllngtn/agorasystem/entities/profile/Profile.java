package dev.rynwllngtn.agorasystem.entities.profile;

import dev.rynwllngtn.agorasystem.dtos.profile.ProfileResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfileUpdateRequestDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Profile {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private UUID profileOwner; //A ser vinculado com entidade user do sistema Core.
    private String userName;
    private Date birthDate;
    private boolean active = true;

    public Profile(UUID profileOwner, String userName, Date birthDate) {
        this.profileOwner = profileOwner;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public void update(ProfileUpdateRequestDTO profileUpdateRequestDTO) {
        userName = profileUpdateRequestDTO.getUserName();
        birthDate = profileUpdateRequestDTO.getBirthDate();
        active = profileUpdateRequestDTO.isActive();
    }

}