package com.chadwick.adapters;

import com.chadwick.domain.security.AuthenticationRequest;
import com.chadwick.domain.security.AuthenticationResponse;
import com.chadwick.domain.security.RegisterRequest;
import com.chadwick.domain.security.User;
import com.chadwick.ports.in.AuthServicePort;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationControllerAdapter {

    private final AuthServicePort service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

   @GetMapping("/user")
    public User getUserByToken(@RequestHeader("Authorization") String token) {
        var removeBearer = token.substring(7);
       return service.getUserByToken(removeBearer);
    }


}
