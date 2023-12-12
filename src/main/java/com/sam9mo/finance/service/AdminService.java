package com.sam9mo.finance.service;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.dto.member.request.MemberUpdateRequest;
import com.sam9mo.finance.dto.member.response.MemberDeleteResponse;
import com.sam9mo.finance.dto.member.response.MemberInfoResponse;
import com.sam9mo.finance.dto.member.response.MemberUpdateResponse;
import com.sam9mo.finance.entity.Member;
import com.sam9mo.finance.entity.News;
import com.sam9mo.finance.repository.sql.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    @Transactional(readOnly = true)
    public Map<String, Object> getMembers(int page) {
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, 100, Sort.by("account").ascending());
        Page<MemberInfoResponse> pageTuts = memberRepository.findAllByType(MemberType.USER, paging);
        response.put("membersData", pageTuts.getContent());
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
    @Transactional(readOnly = true)
    public MemberInfoResponse getMember(UUID id) {
        return memberRepository.findById(id)
                .map(MemberInfoResponse::from)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }
    @Transactional(readOnly = true)
    public Map<String, Object> getAdmins() {
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(0, 10, Sort.by("account").ascending());
        Page<MemberInfoResponse> pageTuts = memberRepository.findAllByType(MemberType.ADMIN, paging);
        response.put("adminsData", pageTuts.getContent());
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
    public MemberDeleteResponse deleteMember(UUID id) {
        if (!memberRepository.existsById(id)) return new MemberDeleteResponse(false);
        memberRepository.deleteById(id);
        return new MemberDeleteResponse(true);
    }

    public MemberUpdateResponse updateMember(MemberUpdateRequest updateMember){
        return memberRepository.findById(updateMember.id())
                .map(member -> {
                    member.update(updateMember, encoder);
                    memberRepository.saveAndFlush(member);
                    return MemberUpdateResponse.of(true, member);
                })
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 회원이 존재하지 않습니다."));
    }
}
