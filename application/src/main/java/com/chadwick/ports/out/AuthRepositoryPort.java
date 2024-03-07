package com.chadwick.ports.out;

import com.chadwick.domain.security.AuthenticationRequest;
import com.chadwick.domain.security.AuthenticationResponse;
import com.chadwick.domain.security.RegisterRequest;
import com.chadwick.domain.security.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthRepositoryPort {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException;

    User getUserByToken(String token);
}
