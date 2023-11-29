package com.sam9mo.finance.repository;

import com.sam9mo.finance.entity.MemberRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRefreshTokenRepository extends JpaRepository<MemberRefreshToken, UUID> {
    Optional<MemberRefreshToken> findByMemberIdAndReissueCountLessThan(UUID id, long count);
}
