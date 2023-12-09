package com.sam9mo.finance.service;

import com.sam9mo.finance.entity.KospiCode;
import com.sam9mo.finance.repository.sql.KospiCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KospiService {

    private final KospiCodeRepository kospiCodeRepository;
    public Optional<KospiCode> findByKoreanName(String koreanName){
        return kospiCodeRepository.findByKoreanName(koreanName);
    }
    public Optional<KospiCode> findByAbbreviationCode(String koreanName){
        return kospiCodeRepository.findByAbbreviationCode(koreanName);
    }
    public Optional<KospiCode> findById(String id){
        return kospiCodeRepository.findById(id);
    }
}
