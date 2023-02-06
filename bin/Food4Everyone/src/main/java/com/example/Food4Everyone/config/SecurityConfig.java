package com.example.Food4Everyone.config;

import com.example.Food4Everyone.Service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer
{

    @Autowired
    private UserInfoService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() 
    {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .cors().and().csrf().disable().authorizeRequests().antMatchers("/registration**","/needs","/faq**", "/news**","/news/**","/forgot**",
                 "/PrivacyPolicy**", "/newsPage", "/home**", "/map**", "/foodBanks/**", "/js/**", "/css/**", "/img/**").permitAll()
                 .antMatchers("/ControlPage/**", "/NewsPage/**", "/changecredential/**").hasRole("ADMIN").anyRequest()
        .authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/ControlPage", true).and().logout()
        .invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
        logoutSuccessUrl("/login?logout").permitAll();

    }
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*");
    }
}
