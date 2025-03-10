package dev.elibertocastro.usermanagement.domain.user.dto;

import dev.elibertocastro.usermanagement.domain.user.enums.Sexo;

import java.time.LocalDate;
import java.util.UUID;

public record UserCreateDto(
        String name,
        String email,
        Sexo sexo,
        LocalDate birthDate,
        String cityBirth,
        String stateBirth
) {
}
