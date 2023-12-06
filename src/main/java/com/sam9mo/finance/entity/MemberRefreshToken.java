package com.sam9mo.finance.entity;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.dto.sign_up.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberRefreshToken {
    @Id
    private UUID memberId;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "member_id")
    private Member member;
    private String refreshToken;
    private String accessToken;
    private long accessTokenExpirationDateTime;
    private long refreshTokenExpirationDateTime;
    private String financeAgent;
    private int reissueCount = 0;

    @Builder
    public MemberRefreshToken(Member member, String refreshToken, String accessToken, long accessTokenExpirationDateTime, long refreshTokenExpirationDateTime, String financeAgent) {
        this.member = member;
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.accessTokenExpirationDateTime = accessTokenExpirationDateTime;
        this.refreshTokenExpirationDateTime = refreshTokenExpirationDateTime;
        this.financeAgent = financeAgent;
    }
    public MemberRefreshToken from(Member member) {
        return MemberRefreshToken.builder()
                .member(member)
                .refreshToken(this.refreshToken)
                .accessToken(this.accessToken)
                .accessTokenExpirationDateTime(this.accessTokenExpirationDateTime)
                .refreshTokenExpirationDateTime(this.refreshTokenExpirationDateTime)
                .financeAgent(this.financeAgent)
                .build();
    }
    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public void updateAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public void updateRefreshTokenExpirationDateTime(long refreshTokenExpirationDateTime){
        this.refreshTokenExpirationDateTime = refreshTokenExpirationDateTime;
    }
    public void updateAccessTokenExpirationDateTime(long accessTokenExpirationDateTime) {
        this.accessTokenExpirationDateTime = accessTokenExpirationDateTime;
    }
    public void updateFinanceAgent(String financeAgent){
        this.financeAgent = financeAgent;
    }
    public boolean validateRefreshToken(String refreshToken) {
        return this.refreshToken.equals(refreshToken);
    }

    public void increaseReissueCount() {
        reissueCount++;
    }
}