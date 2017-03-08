package com.example.repository;

import com.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roma on 03.03.2017.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByLogin(String login);

}
