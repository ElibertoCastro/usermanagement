package dev.elibertocastro.usermanagement.adapters.outbound.repositories;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaAuthCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaAuthCredentialRepository extends JpaRepository<JpaAuthCredentialEntity, UUID> {
  Optional<JpaAuthCredentialEntity> findByEmail(String email);
}
