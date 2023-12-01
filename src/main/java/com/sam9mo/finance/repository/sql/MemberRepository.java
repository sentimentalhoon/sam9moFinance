package com.sam9mo.finance.repository.sql;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByAccount(String account);
    List<Member> findAllByType(MemberType type);
}
