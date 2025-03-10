package dev.elibertocastro.usermanagement.adapters.outbound.entities;

import dev.elibertocastro.usermanagement.domain.user.User;
import dev.elibertocastro.usermanagement.domain.user.enums.Sexo;
import dev.elibertocastro.usermanagement.domain.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class JpaUserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;
  private String email;
  @Enumerated(EnumType.STRING)
  private Sexo sexo;
  @Column(name = "birth_date")
  private LocalDate birthDate;
  @Column(name = "city_birth")
  private String cityBirth;
  @Column(name = "state_birth")
  private String stateBirth;
  @Column(name = "created_at")
  private LocalDate createdAt;
  @Column(name = "updated_at")
  private LocalDate updatedAt;

  public JpaUserEntity(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.sexo = user.getSexo();
    this.birthDate = user.getBirthDate();
    this.cityBirth = user.getCityBirth();
    this.stateBirth = user.getStateBirth();
    this.createdAt = user.getCreatedAt();
    this.updatedAt = user.getUpdatedAt();
  }
}
