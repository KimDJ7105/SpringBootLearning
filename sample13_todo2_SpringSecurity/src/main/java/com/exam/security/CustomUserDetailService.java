package com.exam.security;

import com.exam.dto.MemberDTO;
import com.exam.service.AuthenticationService;
import com.exam.service.MemberService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    //Service 주입받기
    AuthenticationService authenticationService;
    public CustomUserDetailService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //사용자가 loginForm에서 로그인 버튼을 클릭할때 자동으로 호출된다.
        //DB 에서 해당되는 아이디가 존재하는지 체크
        //비밀번호는 자동으로 체크 (Security6 부터 제공됨. )
        //DB에서 아이디가 있는지 확인,
        MemberDTO memberDTO = authenticationService.findById(username);
        if(memberDTO == null){ // 없는 경우 예외 발생
            throw new UsernameNotFoundException("해당하는 아이디가 없습니다 : " + username);
        }
        System.out.println("login done");
        //세션(SecurityContextHandler)에 저장할 객체 생성
        return new CustomUserDetails(memberDTO, List.of(new SimpleGrantedAuthority("ROLE_USER")));

    }
}
