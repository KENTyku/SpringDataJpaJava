package com.ardecs.SpringDataJpaJava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.ardecs.SpringDataJpaJava.constants.Constants.ADMIN_ROLE;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.ardecs.SpringDataJpaJava.config")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceCast userDetailsServiceCast;

    @Override
    public void configure(AuthenticationManagerBuilder registry) throws Exception {
//        registry.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
//        ;
        registry.userDetailsService(userDetailsServiceCast);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers(HttpMethod.POST, "/registrationClient").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/clients").hasRole(ADMIN_ROLE)
                .antMatchers("/editProduct").hasRole(ADMIN_ROLE)
                .anyRequest().authenticated()
//                .and().httpBasic()

                .and()
                .formLogin()
                .loginPage("/loginPage").permitAll()
//                .loginProcessingUrl("/loginPage")
//                .defaultSuccessUrl("/cart", true)
//                .failureUrl("/resources/error.html")

                .and()
                .logout()
        ;
    }
}
