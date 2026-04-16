package dev.rynwllngtn.agorasocial.dtos.comment;

import java.time.Instant;

public record CommentResponseDTO(
        String id,
        Instant date,
        String body
) {}