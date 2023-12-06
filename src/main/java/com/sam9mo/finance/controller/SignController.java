package com.sam9mo.finance.controller;

import com.sam9mo.finance.dto.ApiResponse;
import com.sam9mo.finance.dto.sign_in.request.SignInRequest;
import com.sam9mo.finance.dto.sign_up.request.SignUpRequest;
import com.sam9mo.finance.service.SignService;
import com.sun.net.httpserver.Headers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "회원 가입 및 로그인")
@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignController {
    private final SignService signService;

    @Operation(summary = "회원 가입")
    @PostMapping("/sign-up")
    public ApiResponse signUp(@RequestBody SignUpRequest request) {
        return ApiResponse.success(signService.registMember(request));
    }

    @Operation(summary = "로그인")
    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody SignInRequest request, @RequestHeader("finance-agent") String financeAgent) {
        return ApiResponse.success(signService.signIn(request, financeAgent));
    }
}
