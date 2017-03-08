package com.example.service;

import com.example.entity.Client;

/**
 * Created by Roma on 04.03.2017.
 */
public interface ClientService {

    Client addClient(Client client);

    Client findClient(String login);

}
