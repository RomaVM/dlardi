package com.example.validation.annotation;

import com.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Roma on 05.03.2017.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return clientRepository.findByLogin(s) == null;
    }
}
