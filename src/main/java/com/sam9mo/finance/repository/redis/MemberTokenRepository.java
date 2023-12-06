package com.sam9mo.finance.repository.redis;

import lombok.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTokenRepository extends CrudRepository<String, String> {
}
