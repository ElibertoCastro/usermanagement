package dev.elibertocastro.usermanagement.domain.authcredential;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaAuthCredentialEntity;
import dev.elibertocastro.usermanagement.domain.authcredential.dto.AuthCredentialCreateDto;
import dev.elibertocastro.usermanagement.domain.user.enums.UserRole;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.UUID;

public class AuthCredential {
  private UUID id;
  private String email;
  private String password;
  private UserRole role;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  public AuthCredential() {}

  public AuthCredential(UUID id, String email, String password, UserRole role) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public AuthCredential(JpaAuthCredentialEntity authCredentialEntity) {
    this.id = authCredentialEntity.getId();
    this.email = authCredentialEntity.getEmail();
    this.password = authCredentialEntity.getPassword();
    this.role = authCredentialEntity.getRole();
  }

  public AuthCredential(AuthCredentialCreateDto authCredentialCreateDto) {
    this.email = authCredentialCreateDto.email();
    this.password = authCredentialCreateDto.password();
    this.role = authCredentialCreateDto.role();
    this.createdAt = LocalDate.now();
    this.updatedAt = LocalDate.now();
  }

  public UUID getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public UserRole getRole() {
    return role;
  }
  public LocalDate getCreatedAt() {
    return createdAt;
  }
  public LocalDate getUpdatedAt() {
    return updatedAt;
  }
}
