package dev.elibertocastro.usermanagement.adapters.outbound.repositories;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaAuthCredentialEntity;
import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaUserEntity;
import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;
import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AuthCredentialRepositoryImpl implements AuthCredentialRepository {
  @Autowired
  private JpaAuthCredentialRepository jpaAuthCredentialRepository;
  @Autowired
  private JpaUserRepository jpaUserRepository;


  @Override
  public AuthCredential save(AuthCredential authCredential) {
    Optional<JpaUserEntity> userEntityOptional = jpaUserRepository.findByEmail(authCredential.getEmail());
    if(userEntityOptional.isPresent()) {
      var userEntity = userEntityOptional.get();
      var authCredentialEntity = jpaAuthCredentialRepository.save(new JpaAuthCredentialEntity(authCredential, userEntity));
      return new AuthCredential(authCredentialEntity);
    }
    return null;
  }

  @Override
  public AuthCredential findById(UUID id) {
    Optional<JpaAuthCredentialEntity> authCredentialEntity = jpaAuthCredentialRepository.findById(id);
    return authCredentialEntity.stream().map(AuthCredential::new).findFirst().orElse(null);
  }

  @Override
  public AuthCredential findByEmail(String email) {
    Optional<JpaAuthCredentialEntity> authCredentialEntity = jpaAuthCredentialRepository.findByEmail(email);
    return authCredentialEntity.stream().map(AuthCredential::new).findFirst().orElse(null);
  }

//  @Override
//  public AuthCredential update(AuthCredential authCredential) {
//    return null;
//  }

  @Override
  public void delete(UUID id) {
    jpaAuthCredentialRepository.deleteById(id);
  }
}
