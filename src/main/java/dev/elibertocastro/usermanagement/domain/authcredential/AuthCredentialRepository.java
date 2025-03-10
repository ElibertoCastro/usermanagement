package dev.elibertocastro.usermanagement.domain.authcredential;

import java.util.UUID;

public interface AuthCredentialRepository {
    AuthCredential save(AuthCredential authCredential);
    AuthCredential findById(UUID id);
    AuthCredential findByEmail(String email);
//    AuthCredential update(AuthCredential authCredential);
    void delete(UUID id);
}
