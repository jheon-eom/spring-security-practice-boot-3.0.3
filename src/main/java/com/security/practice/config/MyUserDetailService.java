package com.security.practice.config;

import com.security.practice.domain.Member;
import com.security.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member findMember = memberService.findByUserId(userId);
        return User.builder()
                .username(findMember.getUserId())
                .password(findMember.getPassword())
                .roles(findMember.getRoles().name())
                .build();
    }
}
