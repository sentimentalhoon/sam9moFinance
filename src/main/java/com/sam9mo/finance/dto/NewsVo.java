package com.sam9mo.finance.dto;

import com.sam9mo.finance.entity.News;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NewsVo {
    private String newsCategory;
    private String stockCompany;
    private String newsYear;
    private String newsMonth;
    private String newsDay;
    private int page;

    @Builder
    public void NewVo(String newsCategory, String stockCompany, String newsYear, String newsMonth, String newsDay, int page){
        this.newsCategory = newsCategory;
        this.stockCompany = stockCompany;
        this.newsYear = newsYear;
        this.newsMonth = newsMonth;
        this.newsDay = newsDay;
        this.page = page;
    }
}
