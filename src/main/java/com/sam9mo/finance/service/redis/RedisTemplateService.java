package com.sam9mo.finance.service.redis;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisTemplateService {
    void save();
    <T> T getData(String key, Class<T> classType);
}
