package com.sam9mo.finance.service.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam9mo.finance.entity.StockHokaDomestic;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisTemplateServiceImpl implements RedisTemplateService{
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(){
    }
    @Override
    public <T> T getData(String key, Class<T> classType) {
        String jsonResult = (String)redisTemplate.opsForValue().get(key);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonResult, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}