package dev.rynwllngtn.agorasocial.dtos.post;

import java.time.Instant;

public record PostResponseDTO(
        String id,
        Instant date,
        String title,
        String body
) {}