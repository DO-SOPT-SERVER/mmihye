package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.request.member.MemberCreateRequest;
import com.server.dosopt.seminar.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable("memberId") Long memberId) {
        MemberGetResponse response = memberService.getByIdV1(memberId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{memberId}/v2", produces = "application/json")
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location = URI.create("api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();

    }
}