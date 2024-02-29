package com.chadwick.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicsMO {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private RoleMO role;
}
