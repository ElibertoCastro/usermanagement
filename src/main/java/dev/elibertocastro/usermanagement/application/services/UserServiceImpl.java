package dev.elibertocastro.usermanagement.application.services;

import dev.elibertocastro.usermanagement.adapters.outbound.repositories.UserRepositoryImpl;
import dev.elibertocastro.usermanagement.application.usercases.UserUseCases;
import dev.elibertocastro.usermanagement.domain.user.User;
import dev.elibertocastro.usermanagement.domain.user.dto.UserCreateDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserUseCases {
  @Autowired
  private UserRepositoryImpl userRepository;

  @Transactional
  @Override
  public User createUser(UserCreateDto userCreateDto) {
    var user = new User(userCreateDto);
    return userRepository.save(user);
  }

  @Override
  public User findUserById(UUID id) {
    return userRepository.findById(id);
  }

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }
}
