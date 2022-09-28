package cn.j2go.mall.demo.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/css/**", "/images/**", "/layui/**", "/mods/**", "/reg")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringAntMatchers("/message/**")
                .and()
                .formLogin()
//                .loginPage("/login")
                // 支持跳转登录认证之前的链接的 Handler
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                // 使用 `.logoutUrl("/user/logout")` 的方式只支持 POST 方式登出
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .deleteCookies("remember-me")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .build();
    }
}
