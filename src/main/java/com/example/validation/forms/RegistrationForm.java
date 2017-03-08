package com.example.validation.forms;

import com.example.validation.annotation.UniqueUsername;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Roma on 04.03.2017.
 */
public class RegistrationForm {

    @NotNull
    @Size(min = 5, message = "Ваше ФИО должен быть не мение 5 символов")
    private String fullName;

    @NotNull
    @Size(min = 3, message = "Ваш логин должен быть не мение 3 символов")
    @Pattern(regexp = "^[\\s\\w\\d]*$", message = "Разрешены только английские буквы и цифры")
    @UniqueUsername(message = "Такой логин уже существует")
    private String login;

    @NotNull(message = "Поле Пароль не должно быть пустым")
    @Size(min = 5, message = "Ваш пароль должен быть не мение 5 символов")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
