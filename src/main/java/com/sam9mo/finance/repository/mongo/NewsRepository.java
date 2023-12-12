package com.sam9mo.finance.repository.mongo;

import com.sam9mo.finance.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends MongoRepository<News, String> {

    Page<News> findByStockCompanyContainingIgnoreCase(String stockCompany, Pageable pageable);
    Page<News> findByNewsCategoryContainingIgnoreCase(String newsCategory, Pageable pageable);
    Page<News> findByNewsYearAndNewsMonthAndNewsDay(String newsYear, String newsMonth, String newsDay, Pageable pageable);

    @Aggregation(pipeline = { "{ $group: { _id: \"$stock_company\" } }", "{ $project: { _id: 0, stock_company: \"$_id\" } }" })
    List<String> findDistinctStockCompany();
    @Aggregation(pipeline = { "{ $group: { _id: \"$news_category\" } }", "{ $project: { _id: 0, news_category: \"$_id\" } }" })
    List<String> findDistinctNewsCategory();
}