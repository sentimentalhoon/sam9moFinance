package com.sam9mo.finance.entity;

import com.sam9mo.finance.dto.member.request.MemberUpdateRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection="news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    @Field("_id")
    private String id;
    @Field("news_year")
    private String newsYear;
    @Field("news_month")
    private String newsMonth;
    @Field("news_day")
    private String newsDay;
    @Field("news_id")
    private String newsId;
    @Field("news_company")
    private String newsCompany;
    @Field("news_category")
    private String newsCategory;
    @Field("news_link")
    private String newsLink;
    @Field("news_img")
    private String newsImg;
    @Field("news_title")
    private String newsTitle;
    @Field("stock_company")
    private String stockCompany;
    @Field("news_time")
    private String newsTime;
    @Field("content_summary")
    private String contentSummary;
    @Field("keyword")
    private String keyword;
    @Field("news_sentiment")
    private String newsSentiment;
    @Field("data_input_time")
    private String dataInputTime;
    @Field("news_content")
    private String newsContent;

    public void update(News updateNews) {
        this.newsYear = updateNews.newsYear;
        this.newsMonth = updateNews.newsMonth;
    }
}