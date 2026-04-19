package dev.rynwllngtn.agorasocial.dtos.post;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequestDTO(
        @NotBlank(message = "ID de autor não pode ser vázio ou null!")
        String author,
        @NotBlank(message = "Titulo não pode ser vázio ou null!")
        String title,
        @NotBlank(message = "Corpo não pode ser vázio ou null!")
        String body
) {}