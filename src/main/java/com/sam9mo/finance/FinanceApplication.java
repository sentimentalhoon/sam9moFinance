package com.sam9mo.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.sam9mo.finance.repository.mongo"})
@EnableJpaRepositories(basePackages = {"com.sam9mo.finance.repository.sql"})
@EnableRedisRepositories(basePackages = {"com.sam9mo.finance.repository.redis"})
public class FinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);
    }

}
