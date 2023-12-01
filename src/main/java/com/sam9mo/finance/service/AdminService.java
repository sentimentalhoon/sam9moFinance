package com.sam9mo.finance.service;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.dto.member.request.MemberUpdateRequest;
import com.sam9mo.finance.dto.member.response.MemberDeleteResponse;
import com.sam9mo.finance.dto.member.response.MemberInfoResponse;
import com.sam9mo.finance.dto.member.response.MemberUpdateResponse;
import com.sam9mo.finance.entity.Member;
import com.sam9mo.finance.repository.sql.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    @Transactional(readOnly = true)
    public List<MemberInfoResponse> getMembers() {
        return memberRepository.findAllByType(MemberType.USER).stream()
                .map(MemberInfoResponse::from)
                .toList();
    }
    @Transactional(readOnly = true)
    public MemberInfoResponse getMember(UUID id) {
        return memberRepository.findById(id)
                .map(MemberInfoResponse::from)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }
    @Transactional(readOnly = true)
    public List<MemberInfoResponse> getAdmins() {
        return memberRepository.findAllByType(MemberType.ADMIN).stream()
                .map(MemberInfoResponse::from)
                .toList();
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
