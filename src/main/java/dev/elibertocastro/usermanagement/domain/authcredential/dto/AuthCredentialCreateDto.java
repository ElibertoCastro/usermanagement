package dev.elibertocastro.usermanagement.domain.authcredential.dto;

import dev.elibertocastro.usermanagement.domain.user.enums.UserRole;

public record AuthCredentialCreateDto(
        String email,
        String password,
        UserRole role
) {
}
