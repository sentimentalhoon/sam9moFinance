package com.sam9mo.finance.dto.sign_in.response;

import com.sam9mo.finance.common.MemberType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Date;

public record SignInResponse(
        @Schema(description = "회원 이름", example = "콜라곰")
        String name,
        @Schema(description = "회원 유형", example = "USER")
        MemberType type,
        String accessToken,
        String refreshToken,
        LocalDateTime lastConnectedTime,
        long accessTokenExpirationDateTime,
        long refreshTokenExpirationDateTime
) {}
