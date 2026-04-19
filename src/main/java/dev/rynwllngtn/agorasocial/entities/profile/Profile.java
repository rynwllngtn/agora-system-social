package dev.rynwllngtn.agorasocial.entities.profile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "profiles")
public class Profile {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private UUID profileOwner; //A ser vinculado com entidade user do sistema Core.
    private String userName;
    private LocalDate birthDate;
    private boolean active;

    public Profile(UUID profileOwner, String userName, LocalDate birthDate) {
        this.profileOwner = profileOwner;
        this.userName = userName;
        this.birthDate = birthDate;
        active = true;
    }

}