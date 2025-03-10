package dev.elibertocastro.usermanagement.application.services;

import dev.elibertocastro.usermanagement.adapters.outbound.repositories.AuthCredentialRepositoryImpl;
import dev.elibertocastro.usermanagement.application.usercases.AuthCredentialUseCases;
import dev.elibertocastro.usermanagement.domain.authcredential.AuthCredential;
import dev.elibertocastro.usermanagement.domain.authcredential.dto.AuthCredentialCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthCredentialServiceImpl implements AuthCredentialUseCases {
    @Autowired
    private AuthCredentialRepositoryImpl authCredentialRepository;
    @Override
    public AuthCredential createAuthCredential(AuthCredentialCreateDto authCredentialCreateDto) {
        var authCredential = new AuthCredential(authCredentialCreateDto);
        return authCredentialRepository.save(authCredential);
    }

    @Override
    public AuthCredential findAuthCredentialByEmail(String email) {
        return authCredentialRepository.findByEmail(email);
    }

    @Override
    public AuthCredential findAuthCredentialById(UUID id) {
        return authCredentialRepository.findById(id);
    }
}
