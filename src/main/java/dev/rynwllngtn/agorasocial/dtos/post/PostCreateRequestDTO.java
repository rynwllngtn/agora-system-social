package dev.rynwllngtn.agorasocial.dtos.post;

public record PostCreateRequestDTO(
        String author,
        String title,
        String body
) {}