package dev.elibertocastro.usermanagement.adapters.outbound.entities;

import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;
import dev.elibertocastro.usermanagement.domain.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "auth_credentials", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaAuthCredentialEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private JpaUserEntity userEntity;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private UserRole role;
  @Column(name = "created_at")
  private LocalDate createdAt;
  @Column(name = "updated_at")
  private LocalDate updatedAt;

  public JpaAuthCredentialEntity(AuthCredential authCredential, JpaUserEntity userEntity) {
    this.id = authCredential.getId();
    this.userEntity = userEntity;
    this.email = authCredential.getEmail();
    this.password = authCredential.getPassword();
    this.role = authCredential.getRole();
    this.createdAt = authCredential.getCreatedAt();
    this.updatedAt = authCredential.getUpdatedAt();
  }
}
