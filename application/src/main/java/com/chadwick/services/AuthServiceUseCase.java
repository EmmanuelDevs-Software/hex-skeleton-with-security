package com.chadwick.services;

import com.chadwick.domain.security.AuthenticationRequest;
import com.chadwick.domain.security.AuthenticationResponse;
import com.chadwick.domain.security.RegisterRequest;
import com.chadwick.domain.security.User;
import com.chadwick.ports.in.AuthServicePort;
import com.chadwick.ports.out.AuthRepositoryPort;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceUseCase implements AuthServicePort {

    private final AuthRepositoryPort authRepository;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        return authRepository.register(registerRequest);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        return authRepository.authenticate(authenticationRequest);
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {
        authRepository.saveUserToken(user, jwtToken);
    }

    @Override
    public void revokeAllUserTokens(User user) {
        authRepository.revokeAllUserTokens(user);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authRepository.refreshToken(request, response);
    }
}
