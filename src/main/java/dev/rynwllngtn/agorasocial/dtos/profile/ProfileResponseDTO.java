package dev.rynwllngtn.agorasocial.dtos.profile;

import java.util.Date;

public record ProfileResponseDTO(
        String id,
        String userName,
        Date birthDate,
        boolean active
) {}