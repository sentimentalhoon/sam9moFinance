package com.sam9mo.finance.service;

import com.sam9mo.finance.dto.sign_in.request.SignInRequest;
import com.sam9mo.finance.dto.sign_in.response.SignInResponse;
import com.sam9mo.finance.dto.sign_up.request.SignUpRequest;
import com.sam9mo.finance.dto.sign_up.response.SignUpResponse;
import com.sam9mo.finance.entity.Member;
import com.sam9mo.finance.entity.MemberRefreshToken;
import com.sam9mo.finance.repository.sql.MemberRefreshTokenRepository;
import com.sam9mo.finance.repository.sql.MemberRepository;
import com.sam9mo.finance.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SignService {
    private final MemberRepository memberRepository;
    private final MemberRefreshTokenRepository memberRefreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder encoder;

    @Transactional
    public SignUpResponse registMember(SignUpRequest request) {
        Member member = memberRepository.save(Member.from(request, encoder));
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        return SignUpResponse.from(member);
    }
    @Value("${expiration-minutes}")
    private long expirationMinutes;
    @Value("${refresh-expiration-hours}")
    private long refreshExpirationHours;

    @Transactional
    public SignInResponse signIn(SignInRequest request, String financeAgent) {
        Member member = memberRepository.findByAccount(request.account())
                .filter(it -> encoder.matches(request.password(), it.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        String accessToken = tokenProvider.createAccessToken(String.format("%s:%s", member.getId(), member.getType()));
        String refreshToken = tokenProvider.createRefreshToken();
        long accessTokenExpirationDateTime = tokenProvider.getTokenExpirationDateTime(accessToken);
        long refreshTokenExpirationDateTime = tokenProvider.getTokenExpirationDateTime(refreshToken);
        memberRefreshTokenRepository.findById(member.getId())
                .ifPresentOrElse(
                        (memberRefreshToken) -> {
                            memberRefreshToken.updateRefreshToken(refreshToken);
                            memberRefreshToken.updateRefreshTokenExpirationDateTime(refreshTokenExpirationDateTime);
                            memberRefreshToken.updateAccessToken(accessToken);
                            memberRefreshToken.updateAccessTokenExpirationDateTime(accessTokenExpirationDateTime);
                            memberRefreshToken.updateFinanceAgent(financeAgent);

                            },
                        () -> {
                            MemberRefreshToken memberRefreshToken = new MemberRefreshToken(member, refreshToken, accessToken, accessTokenExpirationDateTime, refreshTokenExpirationDateTime, financeAgent);

                            memberRefreshTokenRepository.save(memberRefreshToken);
                        }

                );
        LocalDateTime oldLastConnectedTime = member.getLastConnectedAt();
        member.updateLastConnectedAt();
        memberRepository.save(member);
        return new SignInResponse(member.getName(), member.getType(), accessToken, refreshToken, oldLastConnectedTime, accessTokenExpirationDateTime, refreshTokenExpirationDateTime);
    }
}
