package dev.elibertocastro.usermanagement.adapters.outbound.repositories;

import dev.elibertocastro.usermanagement.adapters.outbound.entities.JpaUserEntity;
import dev.elibertocastro.usermanagement.domain.user.User;
import dev.elibertocastro.usermanagement.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
  @Autowired
  private JpaUserRepository jpaUserRepository;

  @Override
  public User save(User user) {
    JpaUserEntity jpaUserEntity = new JpaUserEntity(user);
    return new User(jpaUserRepository.save(jpaUserEntity));
  }

  @Override
  public User findById(UUID id) {
    Optional<JpaUserEntity> user = jpaUserRepository.findById(id);
    return user.stream().map(User::new).findFirst().orElse(null);
  }

  @Override
  public User findByEmail(String email) {
    Optional<JpaUserEntity> user = jpaUserRepository.findByEmail(email);
    return user.stream().map(User::new).findFirst().orElse(null);
  }

  @Override
  public List<User> findAll() {
    return jpaUserRepository.findAll().stream().map(User::new).toList();
  }

//  @Override
//  public User update(User user) {
//    Optional<JpaUserEntity> userEntity = jpaUserRepository.findById(user.getId());
//    if (userEntity.isPresent()) {
//      JpaUserEntity jpaUserEntity = userEntity.get();
//
//      return new User(jpaUserRepository.save(jpaUserEntity));
//    } else {
//      return null;
//    }
//  }

  @Override
  public void delete(String id) {
    jpaUserRepository.deleteById(id);
  }
}
