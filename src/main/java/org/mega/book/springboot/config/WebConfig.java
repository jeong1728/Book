package org.mega.book.springboot.config;

import lombok.RequiredArgsConstructor;
import org.mega.book.springboot.config.auth.LoginUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration//설정이란소리
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){//매개변수 추가 리스트로받아옴
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
