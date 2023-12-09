package com.sam9mo.finance.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CompanyRequest {
    private String koreanName;
    private String abbreviationCode;

    @Builder
    public void CompanyRequest(String koreanName, String abbreviationCode){
        this.koreanName = koreanName;
        this.abbreviationCode = abbreviationCode;
    }
}
