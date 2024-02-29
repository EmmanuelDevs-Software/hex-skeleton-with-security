package com.chadwick.services;


import com.chadwick.domain.security.ChangePasswordRequest;
import com.chadwick.ports.in.UserServicePort;
import com.chadwick.ports.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceUseCase implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        userRepositoryPort.changePassword(request, connectedUser);
    }
}
