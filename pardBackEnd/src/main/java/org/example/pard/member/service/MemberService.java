package org.example.pard.member.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.dto.MemberUpdateDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;

    // 유저(멤버) 생성
    public void createMember(MemberCreateDTO dto) {
        // CreateDTO 를 entity 로 변환후 저장
        memberRepo.save(new Member().update(dto));
    }

    // 아이디로 유저(멤버) 찾기
    public MemberReadDTO findById(Long id) {
        // entitiy 를 readDTO 로 변환후 리턴
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());  // 만약 null 이라면 Exception throw
    }

    // 모든 멤버 찾기
    public List<MemberReadDTO> findAll() {

        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    // 파트로 맴버 찾기
    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    // 아이디로 유저 삭제
    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }


    public void updateMember(Long id, MemberUpdateDTO dto) {
//        Member member;
//        if (memberRepo.findById(id).isPresent()) {
//            member = memberRepo.findById(id).get();
//            memberRepo.save(member.update(id, dto));
//        }else{
//            throw ()
//        }
        Member member = memberRepo.findById(id).orElseThrow();
    }
}
