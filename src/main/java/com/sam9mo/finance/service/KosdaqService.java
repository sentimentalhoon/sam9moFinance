package com.sam9mo.finance.service;
import com.sam9mo.finance.entity.KosdaqCode;
import com.sam9mo.finance.entity.KospiCode;
import com.sam9mo.finance.repository.sql.KosdaqCodeRepository;
import com.sam9mo.finance.repository.sql.KospiCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KosdaqService {

    private final KosdaqCodeRepository kosdaqCodeRepository;
    public Optional<KosdaqCode> findByKoreanName(String koreanName){
        return kosdaqCodeRepository.findByKoreanName(koreanName);
    }
    public Optional<KosdaqCode> findByAbbreviationCode(String code){
        return kosdaqCodeRepository.findByAbbreviationCode(code);
    }
}
