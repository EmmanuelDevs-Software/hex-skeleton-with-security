package com.chadwick.mappers;

import com.chadwick.domain.security.AuthenticationResponse;
import com.chadwick.domain.security.User;
import com.chadwick.models.auth.AuthenticationResponseMO;
import com.chadwick.models.user.UserMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    AuthenticationResponseMO toModel(AuthenticationResponse authenticationResponse);

    AuthenticationResponse toDomain(AuthenticationResponseMO authenticationResponseMO);

    UserMO toUserModel(User user);

    User toUserDomain(UserMO userMO);
}
