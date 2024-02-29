package com.chadwick.models.auth;

import com.chadwick.models.user.RoleMO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestMO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private RoleMO role;
}
