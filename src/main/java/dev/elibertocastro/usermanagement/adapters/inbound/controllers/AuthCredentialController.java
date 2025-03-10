package dev.elibertocastro.usermanagement.adapters.inbound.controllers;

import dev.elibertocastro.usermanagement.application.services.AuthCredentialServiceImpl;
import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;
import dev.elibertocastro.usermanagement.domain.authcredential.dto.AuthCredentialCreateDto;
import dev.elibertocastro.usermanagement.domain.user.dto.AuthCredentialResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/auth-credentials")
public class AuthCredentialController {
  @Autowired
  private AuthCredentialServiceImpl authCredentialService;

  @PostMapping
  public ResponseEntity<AuthCredentialResponseDto> createAuthCredential(@RequestBody AuthCredentialCreateDto authCredentialCreateDto, UriComponentsBuilder uriComponentsBuilder) {
    var authCredential = authCredentialService.createAuthCredential(authCredentialCreateDto);
    var uri = uriComponentsBuilder.path("/auth-credentials/{id}").buildAndExpand(authCredential.getId()).toUri();
    return ResponseEntity.created(uri).body(new AuthCredentialResponseDto(authCredential));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AuthCredentialResponseDto> findAuthCredentialById(@PathVariable UUID id) {
    var authCredential = authCredentialService.findAuthCredentialById(id);
    return ResponseEntity.ok(new AuthCredentialResponseDto(authCredential));
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<AuthCredentialResponseDto> findAuthCredentialByEmail(@PathVariable String email) {
    var authCredential = authCredentialService.findAuthCredentialByEmail(email);
    return ResponseEntity.ok(new AuthCredentialResponseDto(authCredential));
  }

}
