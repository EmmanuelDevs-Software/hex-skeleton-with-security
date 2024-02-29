package com.chadwick.ports.out;

import com.chadwick.domain.security.ChangePasswordRequest;
import org.springframework.stereotype.Repository;

import java.security.Principal;

@Repository
public interface UserRepositoryPort {
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
