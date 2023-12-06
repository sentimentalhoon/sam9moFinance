package com.sam9mo.finance.repository.sql;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.dto.member.response.MemberInfoResponse;
import com.sam9mo.finance.entity.Member;
import org.apache.kafka.common.message.LeaveGroupResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByAccount(String account);
    Page<MemberInfoResponse> findAllByType(MemberType type, Pageable pageable);
}
