package com.server.dosopt.seminar.dto.request.member;

import com.server.dosopt.seminar.domain.SOPT;
import lombok.Data;


public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
}