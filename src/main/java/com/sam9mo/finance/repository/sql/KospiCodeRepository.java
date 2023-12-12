package com.sam9mo.finance.repository.sql;

import com.sam9mo.finance.entity.KospiCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface KospiCodeRepository  extends JpaRepository<KospiCode, String> {
    Optional<KospiCode> findByKoreanName(String koreanName);
    Optional<KospiCode> findByAbbreviationCode(String code);
}
