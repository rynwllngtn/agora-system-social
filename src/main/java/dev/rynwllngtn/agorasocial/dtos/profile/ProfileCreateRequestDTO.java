package dev.rynwllngtn.agorasocial.dtos.profile;

import java.util.Date;
import java.util.UUID;

public record ProfileCreateRequestDTO(
        UUID profileOwner,
        String userName,
        Date birthDate
) {}