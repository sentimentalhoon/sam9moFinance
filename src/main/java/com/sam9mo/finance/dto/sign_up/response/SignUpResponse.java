package com.sam9mo.finance.dto.sign_up.response;

import com.sam9mo.finance.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record SignUpResponse(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b7a-9b9b9b9b9b9b")
        UUID id,
        @Schema(description = "회원 아이디", example = "colabear754")
        String account,
        @Schema(description = "회원 이름", example = "콜라곰")
        String name,
        @Schema(description = "회원 접속 주소", example = "USER")
        String ip,
        @Schema(description = "회원 접속 브라우저", example = "USER")
        String userAgent
) {
    public static SignUpResponse from(Member member) {
        return new SignUpResponse(
                member.getId(),
                member.getAccount(),
                member.getName(),
                member.getIp(),
                member.getUserAgent()
        );
    }
}
