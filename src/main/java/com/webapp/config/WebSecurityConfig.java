package com.webapp.config;

import com.webapp.service.WorkerDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    private final WorkerDetailsService workerDetailsService;

    public WebSecurityConfig(WorkerDetailsService workerDetailsService)
    {
        this.workerDetailsService = workerDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
                .antMatchers("/add").permitAll()
                .antMatchers("/worker/add").hasAnyAuthority("GEN_DIR", "DIR")
                .antMatchers("/worker/update/**").hasAnyAuthority("GEN_DIR", "DIR")
                .antMatchers("/worker/delete/**").hasAnyAuthority("GEN_DIR", "DIR")
                .antMatchers("/department/add/**").hasAnyAuthority("GEN_DIR")
                .antMatchers("/post/add/**").hasAnyAuthority("GEN_DIR", "DIR")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
            .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(workerDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder () { return new BCryptPasswordEncoder(); }
}
