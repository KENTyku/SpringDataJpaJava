package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserDetailsServiceCast implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    //
    public UserDetails loadUserByUsername(String login) {
        Client client = clientRepository.findById(login).get();
        return new User(client.getLogin(), client.getPassword(), new ArrayList<>());
    }
}
