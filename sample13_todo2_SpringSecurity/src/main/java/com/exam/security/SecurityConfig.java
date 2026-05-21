package com.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //어떤 요청을 비인증할지 설정
        //csrf 비활성화 (실무에서는 활성화 권장)
        //http.csrf(csrf -> csrf.disable());
        http.csrf(AbstractHttpConfigurer::disable);
        //어떤 요청을 비인증할지 설정. (/home 과 /signup은 비인증 설정)
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/home", "/signup","/login").permitAll()
                        //.requestMatchers("/","/home","/signup","/login").hasRole("USER").permitAll()
                        //권한까지 적용 가능.
                        .anyRequest()
                        .authenticated());

        //로그인을 위한 화면 구성
        http.formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        // 로그인 화면을 보여주는 url 명시 @GetMapping("/login)
                        .loginProcessingUrl("/login")
                        //loginFrom.html에서 사용하는 action값, name값 지정

                        /*
                         <form th:action="@{/login}" method="post">
                            아이디 :<input type="text" th:field="*{userid}"><br>
                            비밀번호 :<input type="text" th:field="*{password}"><br>
                            <input type="submit" value="로그인">
                         </form>
                        */
                        .usernameParameter("userid") //id를 지정하는 파라미터를 설정
                        .passwordParameter("password") // 비밀번호를 지정하는 파라미터 설정.
                        //.successForwardUrl("/home");
                        .defaultSuccessUrl("/home", true)
                        // 성공한 경우 rediret로 이동, 두번째 인자가 true이면
                        // 무조건 요청한 url 대신 지정된 url로 이동.
                        //.failureForwardUrl("")
                        .failureUrl("/login?error=true")
                        // 실패한 경우 redirect로 이동.
                        .permitAll());

        //로그아웃을 위한 화면 구성
        http.logout(logout ->
                logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/home")
                        //로그아웃 성공시 이동할 url
                        .invalidateHttpSession(true)
                        //세션 삭제
                        .deleteCookies("JSESSIONID")
                        //쿠키 삭제
                        .permitAll());
        return http.build();
    }

    //암호화를 위해 사용하는 Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
