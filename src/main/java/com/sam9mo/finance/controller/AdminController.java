package com.sam9mo.finance.controller;

import com.sam9mo.finance.dto.ApiResponse;
import com.sam9mo.finance.dto.NewsVo;
import com.sam9mo.finance.dto.member.request.MemberUpdateRequest;
import com.sam9mo.finance.dto.member.response.MemberInfoResponse;
import com.sam9mo.finance.entity.Member;
import com.sam9mo.finance.entity.News;
import com.sam9mo.finance.security.AdminAuthorize;
import com.sam9mo.finance.service.AdminService;
import com.sam9mo.finance.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "관리자용 API")
@RequiredArgsConstructor
@AdminAuthorize
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final NewsService newsService;
    @Operation(summary = "회원 목록 조회")
    @GetMapping("/members")
    public ApiResponse getAllMembers() {
        return ApiResponse.success(adminService.getMembers());
    }
    @Operation(summary = "회원 정보 조회")
    @PostMapping("/members/member")
    public ApiResponse getMember(@RequestBody final Member member) {
        return ApiResponse.success(adminService.getMember(member.getId()));
    }
    @Operation(summary = "회원 정보 수정")
    @PutMapping("/members/member")
    public ApiResponse updateMember(@RequestBody MemberUpdateRequest request) {
        return ApiResponse.success(adminService.updateMember(request));
    }
    @Operation(summary = "회원 목록 삭제")
    @DeleteMapping("/members/member")
    public ApiResponse deleteMember(@RequestBody final Member member) {
        return ApiResponse.success(adminService.deleteMember(member.getId()));
    }

    @Operation(summary = "관리자 목록 조회")
    @GetMapping("/admins")
    public ApiResponse getAllAdmins() {
        return ApiResponse.success(adminService.getAdmins());
    }

    @Operation(summary = "뉴스에 등록된 모든 회사 가져오기")
    @GetMapping("/news/company")
    public ApiResponse getNewsAllCompany() {
        return ApiResponse.success(newsService.findDistinctStockCompany());
    }
    @Operation(summary = "선택한 하나의 뉴스 읽어오기")
    @GetMapping("/news/{id}")
    public ApiResponse getSelectNews(@PathVariable final String id) {
        if(newsService.findById(id).isPresent())
        {
            Map<String, Object> sendNewsData = new HashMap<>();
            sendNewsData.put("newsData", newsService.findById(id).get());
            return ApiResponse.success(sendNewsData);
        }
        return ApiResponse.error("뉴스를 불러오는데 실패하였습니다.");
    }

    @Operation(summary = "최신 뉴스 15개씩 페이징")
    @PostMapping("/news")
    public ApiResponse getAllNews(@RequestBody final NewsVo newsVo) {
        return ApiResponse.success(newsService.getAllTutorialsPage(newsVo.getStockCompany(), newsVo.getNewsCategory(), newsVo.getNewsYear(), newsVo.getNewsMonth(), newsVo.getNewsDay(), newsVo.getPage(), 15));
    }
    @Operation(summary = "하나의 뉴스 업데이트")
    @PutMapping("/news")
    public ApiResponse updateNews(@RequestBody final News news) {
        return ApiResponse.success(newsService.updateNews(news));
    }
    @Operation(summary = "하나의 뉴스 삭제")
    @DeleteMapping("/news")
    public ApiResponse deleteNews() {
        return ApiResponse.success("뉴스 삭제");
    }
}
