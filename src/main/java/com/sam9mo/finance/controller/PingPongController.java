package com.sam9mo.finance.controller;

import com.sam9mo.finance.dto.ApiResponse;
import com.sam9mo.finance.security.UserAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AccessToken Update 를 위한 PingPong API")
@RequiredArgsConstructor
@UserAuthorize
@RestController
public class PingPongController {
    @Operation(summary = "핑퐁")
    @GetMapping("/ping")
    public ApiResponse getPong() {
        return ApiResponse.success("update complete");
    }
}
