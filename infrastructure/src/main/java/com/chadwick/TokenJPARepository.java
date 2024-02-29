package com.chadwick;

import com.chadwick.models.auth.TokenMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenJPARepository extends JpaRepository<TokenMO, Integer> {

    @Query(value = """
            select t from TokenMO t inner join UserMO u\s
            on t.userMO.id = u.id\s
            where u.id = :id and (t.expired = false or t.revoked = false)\s
            """)
    List<TokenMO> findAllValidTokenByUser(Integer id);

    Optional<TokenMO> findByToken(String token);
}
