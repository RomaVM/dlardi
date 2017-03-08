package com.example.service;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Roma on 04.03.2017.
 */
@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return this.clientRepository.saveAndFlush(client);
    }

    @Override
    public Client findClient(String login) {
        return this.clientRepository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = this.clientRepository.findByLogin(s);
        if (client == null) {
            throw new UsernameNotFoundException("такой юзер не найден");
        }
        String password = client.getPassword();
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (s.equals("admin")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }

        return new org.springframework.security.core.userdetails.User(s, password, auth);
    }


}
