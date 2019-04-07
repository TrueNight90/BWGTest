package org.yjr.login.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.Map;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(BrowerSecurityConfig.class);

    @Value("${excludePath}")
    private  String excludePath;

    @Value("#{${roles}}")
    private Map<String,String> roles;

    @Autowired
    private UserDetailsService appUserDetailsService;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置权限对应路径
        for(String key : roles.keySet()){
            http.authorizeRequests().antMatchers(roles.get(key).split(",")).hasRole(key);
        }
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        //super.configure(http);
        http.formLogin()
                //登录页面
                .loginPage("/loginPage")
                //登录action
                .loginProcessingUrl("/forLogin").usernameParameter("username").passwordParameter("password")
                //成功/失败后跳转页面
                .successForwardUrl("/index").failureForwardUrl("/login/error")
                //登出页面
                .and().logout().logoutUrl("/logout")
                //无需登录也可访问页面
                .and().authorizeRequests()
                //.antMatchers("/softs/**","/loginPage","/h2-console/**").permitAll()
                .antMatchers(excludePath.split(",")).permitAll()
                //其余页面需要登录
                .anyRequest().authenticated()
                //允许该页面提交无csrf
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                //允许同源的iframe
                .and().headers().frameOptions().sameOrigin();
        //通过反射
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
