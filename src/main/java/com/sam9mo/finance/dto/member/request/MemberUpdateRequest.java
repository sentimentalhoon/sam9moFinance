package com.sam9mo.finance.dto.member.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record MemberUpdateRequest(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        UUID id,
        @Schema(description = "회원 비밀번호", example = "1234")
        String password,
        @Schema(description = "회원 새 비밀번호", example = "1234")
        String newPassword,
        @Schema(description = "회원 이름", example = "콜라곰")
        String name,
        @Schema(description = "회원 나이", example = "30")
        Integer age
) {
}
