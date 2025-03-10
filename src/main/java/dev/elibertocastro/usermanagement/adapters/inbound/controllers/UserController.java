package dev.elibertocastro.usermanagement.adapters.inbound.controllers;

import dev.elibertocastro.usermanagement.application.services.UserServiceImpl;
import dev.elibertocastro.usermanagement.domain.user.User;
import dev.elibertocastro.usermanagement.domain.user.dto.UserCreateDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserServiceImpl userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserCreateDto userCreateDto, UriComponentsBuilder uriComponentsBuilder) {
    var user = userService.createUser(userCreateDto);
    var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(user);
  }

  @GetMapping("{id}")
  public ResponseEntity<User> findUserById(@PathVariable UUID id) {
    var user = userService.findUserById(id);
    return ResponseEntity.ok(user);
  }

  @GetMapping
  public ResponseEntity<List<User>> findAllUsers() {
    var users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }
}
