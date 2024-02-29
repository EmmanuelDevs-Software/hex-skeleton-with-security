package com.chadwick.models.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequestMO {

    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
