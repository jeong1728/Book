package org.mega.book.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.mega.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;
    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()//csrf을 사용하지 않는다.
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**", "images/**", "/js/**", "h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);//이걸사용하려고한다.
    }

}
