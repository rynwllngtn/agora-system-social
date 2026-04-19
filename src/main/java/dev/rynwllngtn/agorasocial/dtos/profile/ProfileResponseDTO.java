package dev.rynwllngtn.agorasocial.dtos.profile;

import java.time.LocalDate;

public record ProfileResponseDTO(
        String id,
        String userName,
        LocalDate birthDate,
        boolean active
) {}