package dev.elibertocastro.usermanagement.application.usercases;

import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;
import dev.elibertocastro.usermanagement.domain.authcredential.dto.AuthCredentialCreateDto;

import java.util.List;
import java.util.UUID;

public interface AuthCredentialUseCases {
    AuthCredential createAuthCredential(AuthCredentialCreateDto authCredentialCreateDto);
    AuthCredential findAuthCredentialByEmail(String email);
    AuthCredential findAuthCredentialById(UUID id);
}
