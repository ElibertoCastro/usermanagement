package dev.elibertocastro.usermanagement.domain.user.dto;

import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;

import java.util.UUID;

public record AuthCredentialResponseDto(
        UUID id,
        String email,
        String role
) {
  public AuthCredentialResponseDto(AuthCredential authCredential) {
    this(authCredential.getId(), authCredential.getEmail(), authCredential.getRole().name());
  }
}
