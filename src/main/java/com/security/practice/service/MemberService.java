package com.security.practice.service;

import com.security.practice.domain.Member;
import com.security.practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findByUserId(String userId) {
        return memberRepository.findByUserId(userId).orElseThrow(() ->
                new UsernameNotFoundException("존재하지 않는 회원입니다."));
    }
}
