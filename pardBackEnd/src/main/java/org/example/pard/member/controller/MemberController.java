package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
public class MemberController {
    private final MemberService memberService;

    // 유저 생성
    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    // 전체 유저 받아오기
    @GetMapping("")
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        // RequestParam(required = false) -> 필수 아님
        // /pard?part=server 이런식으로 쓸수도, 안쓸수도 있다는 뜻

        if (StringUtils.hasText(part)) { // string is not null or blank
            return memberService.findByPart(part); // 파트로 찾기
        }
        return memberService.findAll(); // 모두 찾기
    }

    // 유저 아이디로 찾기
    @GetMapping("/{id}")
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    // 유저 아이디로 지우기
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    }
}
