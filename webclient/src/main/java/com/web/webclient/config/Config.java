package com.web.webclient.config;

import com.web.webclient.repo.UsersRepository;
import com.web.webclient.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UsersRepository usersRepository;

    public Config(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UsersService(usersRepository);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider doDaoAuthenticationProvider = new DaoAuthenticationProvider();
        doDaoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        doDaoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return doDaoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER").antMatchers("/admin/**")
                .hasRole("ADMIN").antMatchers("/**").permitAll().and().formLogin()
                .loginPage("/web/login").loginProcessingUrl("/web/login").defaultSuccessUrl("/user/profile")
                .and().csrf().disable();
    }
}
