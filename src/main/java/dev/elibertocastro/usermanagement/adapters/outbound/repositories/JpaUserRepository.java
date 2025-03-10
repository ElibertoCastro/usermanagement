package dev.elibertocastro.usermanagement.adapters.outbound.repositories;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, String> {
  Optional<JpaUserEntity> findByEmail(String email);
  Optional<JpaUserEntity> findById(UUID id);
}
