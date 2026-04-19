package dev.rynwllngtn.agorasocial.dtos.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.UUID;

public record ProfileCreateRequestDTO(
        @NotNull(message = "ID de dono não pode ser vázio ou null!")
        UUID profileOwner,
        @NotBlank(message = "Username não pode ser vázio ou null!")
        String userName,
        @Past @NotNull(message = "Data de nascimento não pode ser null!")
        LocalDate birthDate
) {}