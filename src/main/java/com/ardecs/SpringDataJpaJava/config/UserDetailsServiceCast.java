package com.ardecs.SpringDataJpaJava.config;

import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceCast implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Client client = clientRepository.findById(login).get();
        return new User(client.getLogin(), client.getPassword(), getAuthorities(client.getRole()));
    }

    private static List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
