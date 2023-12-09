package com.sam9mo.finance.repository.sql;

import com.sam9mo.finance.entity.KosdaqCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KosdaqCodeRepository extends JpaRepository<KosdaqCode, String> {
    Optional<KosdaqCode> findByKoreanName(String koreanName);

    Optional<KosdaqCode> findByAbbreviationCode(String code);
}
