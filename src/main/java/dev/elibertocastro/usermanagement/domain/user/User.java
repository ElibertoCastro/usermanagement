package dev.elibertocastro.usermanagement.domain.user;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaUserEntity;
import dev.elibertocastro.usermanagement.domain.user.dto.UserCreateDto;
import dev.elibertocastro.usermanagement.domain.user.enums.Sexo;

import java.time.LocalDate;
import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  private String email;
  private Sexo sexo;
  private LocalDate birthDate;
  private String cityBirth;
  private String stateBirth;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  public User() {}
  public User(UUID id, String name, String email, Sexo sexo, LocalDate birthDate, String cityBirth, String stateBirth, LocalDate createdAt, LocalDate updatedAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.sexo = sexo;
    this.birthDate = birthDate;
    this.cityBirth = cityBirth;
    this.stateBirth = stateBirth;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public User(JpaUserEntity userEntity) {
    this.id = userEntity.getId();
    this.name = userEntity.getName();
    this.email = userEntity.getEmail();
    this.sexo = userEntity.getSexo();
    this.birthDate = userEntity.getBirthDate();
    this.cityBirth = userEntity.getCityBirth();
    this.stateBirth = userEntity.getStateBirth();
    this.createdAt = userEntity.getCreatedAt();
    this.updatedAt = userEntity.getUpdatedAt();
  }

  public User(UserCreateDto userCreateDto) {
    this.name = userCreateDto.name();
    this.email = userCreateDto.email();
    this.sexo = userCreateDto.sexo();
    this.birthDate = userCreateDto.birthDate();
    this.cityBirth = userCreateDto.cityBirth();
    this.stateBirth = userCreateDto.stateBirth();
    this.createdAt = LocalDate.now();
    this.updatedAt = LocalDate.now();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Sexo getSexo() {
    return sexo;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getCityBirth() {
    return cityBirth;
  }

  public String getStateBirth() {
    return stateBirth;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }
}




