package com.wallet.biochain.repositories;
import com.wallet.biochain.dto.RefreshTokenRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenRequest, Long> {
    Optional<RefreshTokenRequest> findByToken(String token);
}
