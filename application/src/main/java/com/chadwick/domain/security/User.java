package com.chadwick.domain.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private List<TokenDomain> tokens;
}
