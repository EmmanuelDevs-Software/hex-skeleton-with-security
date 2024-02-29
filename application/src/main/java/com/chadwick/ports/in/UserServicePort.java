package com.chadwick.ports.in;

import com.chadwick.domain.security.ChangePasswordRequest;

import java.security.Principal;

public interface UserServicePort {

    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
