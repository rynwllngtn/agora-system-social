package dev.rynwllngtn.agorasocial.dtos.comment;

public record CommentCreateRequestDTO(
        String author,
        String post,
        String body
) {}