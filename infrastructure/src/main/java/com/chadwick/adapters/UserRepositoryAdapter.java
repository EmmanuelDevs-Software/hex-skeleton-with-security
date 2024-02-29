package com.chadwick.adapters;

import com.chadwick.UserJPARepository;
import com.chadwick.domain.security.ChangePasswordRequest;
import com.chadwick.models.user.UserMO;
import com.chadwick.ports.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Slf4j
@Service
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final PasswordEncoder passwordEncoder;
    private final UserJPARepository repository;

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (UserMO) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }
}
