package dev.elibertocastro.usermanagement.application.usercases;

import dev.elibertocastro.usermanagement.domain.user.User;
import dev.elibertocastro.usermanagement.domain.user.dto.UserCreateDto;

import java.util.List;
import java.util.UUID;

public interface UserUseCases {
  User createUser(UserCreateDto user);
  User findUserById(UUID id);
  List<User> findAllUsers();
}
