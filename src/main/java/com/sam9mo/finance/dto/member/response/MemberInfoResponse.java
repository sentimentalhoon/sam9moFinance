package com.sam9mo.finance.dto.member.response;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record MemberInfoResponse(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        UUID id,
        @Schema(description = "회원 아이디", example = "colabear754")
        String account,
        @Schema(description = "회원 이름", example = "콜라곰")
        String name,
        @Schema(description = "회원 타입", example = "USER")
        MemberType type,
        @Schema(description = "회원 접속 주소", example = "USER")
        String ip,
        @Schema(description = "회원 접속 브라우저", example = "USER")
        String userAgent,
        @Schema(description = "회원 생성일", example = "2023-05-11T15:00:00")
        LocalDateTime createdAt,
        @Schema(description = "최근 접속일", example = "2023-05-11T15:00:00")
        LocalDateTime lastConnectedAt
) {
    public static MemberInfoResponse from(Member member) {
        return new MemberInfoResponse(
                member.getId(),
                member.getAccount(),
                member.getName(),
                member.getType(),
                member.getIp(),
                member.getUserAgent(),
                member.getCreatedAt(),
                member.getLastConnectedAt()
        );
    }
}
