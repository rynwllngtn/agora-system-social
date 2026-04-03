package dev.rynwllngtn.agorasystem.dtos.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProfileCreateRequestDTO {

    private UUID profileOwner;
    private String userName;
    private Date birthDate;

}