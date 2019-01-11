package com.ardecs.SpringDataJpaJava.config;

import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.UserDetailsServiceCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceCast userDetailsServiceCast;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
        ;
    }

    protected void configure(HttpSecurity http,AuthenticationManagerBuilder authManBuilder) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/editProduct").hasRole("USER")
//                .antMatchers("/saveProduct").permitAll()
//                .antMatchers("/WEB-INF/views/editProduct.jsp").hasRole("USER")
                .antMatchers("/resources/images/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers(HttpMethod.POST,"/registrationClient").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/clients").permitAll()
                .anyRequest().authenticated()
//                .and().httpBasic()

                .and()
                .formLogin()
                .loginPage("/loginPage").permitAll()
//                .loginProcessingUrl("/resources/images/sun.png")
//                .defaultSuccessUrl("/cart", true)
                .failureUrl("/resources/error.html")

                .and()
                .logout()
        ;
        authManBuilder.userDetailsService(userDetailsServiceCast);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
