package org.yjr.login.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yjr.login.Service.AppUserDetailsService;

import java.lang.reflect.Method;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserDetailsService appUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.formLogin()
                .loginPage("/login1")
                .loginProcessingUrl("/forLogin").usernameParameter("username").passwordParameter("password")
                .successForwardUrl("/Index").failureForwardUrl("/login/error")
                .and().logout().logoutUrl("/logout")
                .and().authorizeRequests()
                .antMatchers("/softs/**","/login1","/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin();
        /*Class c = HttpSecurity.class;
        Method csrf = c.getMethod("csrf");
        CsrfConfigurer<HttpSecurity> csrfConfigurer = (CsrfConfigurer<HttpSecurity>)csrf.invoke(http);
        csrfConfigurer.ignoringAntMatchers("/h2-console/**");*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(appUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
