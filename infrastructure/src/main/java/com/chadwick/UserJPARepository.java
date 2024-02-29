package com.chadwick;


import com.chadwick.models.user.UserMO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserMO, Integer> {

    Optional<UserMO> findByEmail(String email);

    Optional<UserMO> findById(Integer id);

}
