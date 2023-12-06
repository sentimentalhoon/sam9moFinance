package com.sam9mo.finance.dto.sign_up.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignUpRequest(
        @Schema(description = "회원 아이디", example = "colabear754")
        String account,
        @Schema(description = "회원 비밀번호", example = "1234")
        String password,
        @Schema(description = "회원 이름", example = "콜라곰")
        String name,
        @Schema(description = "회원 접속 주소", example = "USER")
        String ip,
        @Schema(description = "회원 접속 브라우저", example = "USER")
        String userAgent
) {
}
