package com.sam9mo.finance.service;

import com.sam9mo.finance.dto.member.response.MemberUpdateResponse;
import com.sam9mo.finance.entity.News;
import com.sam9mo.finance.repository.mongo.NewsRepository;
import lombok.RequiredArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.*;

@RequiredArgsConstructor
@Service
public class NewsService {
    private final NewsRepository newsRepository;
    public Map<String, Object> getAllTutorialsPage(
            @RequestParam String stockCompany,
            @RequestParam String newsCategory,
            @RequestParam String newsYear,
            @RequestParam String newsMonth,
            @RequestParam String newsDay,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {

        Map<String, Object> response = new HashMap<>();
        try {
            List<News> newsData = new ArrayList<News>();
            Pageable paging = PageRequest.of(page, size);

            Page<News> pageTuts;

            if (stockCompany != null)
                pageTuts = newsRepository.findByStockCompanyContainingIgnoreCase(stockCompany, paging);
            else if (newsCategory != null)
                pageTuts = newsRepository.findByNewsCategoryContainingIgnoreCase(newsCategory, paging);
            else if (newsYear != null && newsMonth != null && newsDay != null)
                pageTuts = newsRepository.findByNewsYearAndNewsMonthAndNewsDay(newsYear, newsMonth, newsDay, paging);
            else
                pageTuts = newsRepository.findAll(paging);

            newsData = pageTuts.getContent();

            response.put("newsData", newsData);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return response;
        } catch (Exception e) {
            response.put("error", "data load error");
            response.put("newsData", null);
            response.put("currentPage", null);
            response.put("totalItems", null);
            response.put("totalPages", null);
            return response;
        }
    }

    public Boolean updateNews(News news){
        return newsRepository.findById(news.getId())
                .map(findNews -> {
                    findNews.update(news);
                    newsRepository.save(findNews);
                    return true;
                })
                .orElseThrow(() -> new IllegalArgumentException("해당 뉴스를 찾을 수 없습니다."));
    }

    public List<String> findDistinctNewsCompany() { return newsRepository.findDistinctNewsCompany(); }
    public Optional<News> findById(String id){
        return newsRepository.findById(id);
    }
}
