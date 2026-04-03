package dev.rynwllngtn.agorasystem.dtos.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProfileUpdateRequestDTO {

    @NotBlank(message = "Digite um username!")
    private String userName;

    @NotNull(message = "Digite uma data!")
    private Date birthDate;

    @NotNull(message = "Digite um status de atividade!")
    private boolean active;

}