package com.sam9mo.finance.entity;

import com.sam9mo.finance.common.MemberType;
import com.sam9mo.finance.dto.member.request.MemberUpdateRequest;
import com.sam9mo.finance.dto.sign_up.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false, scale = 20, unique = true)
    private String account;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberType type;
    private String ip;
    private String userAgent;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime lastConnectedAt;

    public static Member from(SignUpRequest request, PasswordEncoder encoder) {
        return Member.builder()
                .account(request.account())
                .password(encoder.encode(request.password()))
                .name(request.name())
                .ip(request.ip())
                .userAgent(request.userAgent())
                .type(MemberType.USER)
                .build();
    }

    @Builder
    private Member(String account, String password, String name, MemberType type, String ip, String userAgent) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.type = type;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public void update(MemberUpdateRequest newMember, PasswordEncoder encoder) {
        this.password = newMember.newPassword() == null || newMember.newPassword().isBlank()
                ? this.password : encoder.encode(newMember.newPassword());
        this.name = newMember.name();
        this.ip = ip;
    }
    public void updateLastConnectedAt(){
        this.lastConnectedAt = now();
    }
}
