package com.example.controller;

import com.example.entity.Client;
import com.example.service.ClientService;
import com.example.validation.forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.validation.Valid;

/**
 * Created by Roma on 04.03.2017.
 */
@Controller
public class ClientController extends WebMvcConfigurerAdapter {

    @Autowired
    private ClientService clientService;

    @GetMapping("/registration")
    public String registration(RegistrationForm registrationForm) {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveClient(@Valid RegistrationForm registrationForm,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            Client client = new Client();
            client.setFullName(registrationForm.getFullName());
            client.setLogin(registrationForm.getLogin());
            client.setPassword(registrationForm.getPassword());
            this.clientService.addClient(client);
            return "login";
        }
    }
}
