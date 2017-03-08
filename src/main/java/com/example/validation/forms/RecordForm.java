package com.example.validation.forms;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Roma on 06.03.2017.
 */
public class RecordForm {

    @NotNull(message = "Поле Имя не должно быть пустым")
    @Size(min = 4, message = "Ваше имя должно иметь не мение 4 символов")
    private String firstName;

    @NotNull(message = "Поле Фамилия не должно быть пустым")
    @Size(min = 4, message = "Ваша фамилия должна иметь не мение 4 символов")
    private String lastName;

    @NotNull(message = "Поле Отчество не должно быть пустым")
    @Size(min = 4, message = "Ваше отчество должно иметь не мение 4 символов")
    private String middleName;

    @NotNull(message = "Поле Мобильный Телефон не должно быть пустым")
    @Pattern(regexp = "[\\+]\\d{3}[\\(]\\d{2}[\\)]\\d{3}[\\-]\\d{2}[\\-]\\d{2}", message = "Мобильный телефон должен быть такого вида: +380(99)999-99-99")
    private String mobileTel;

    private String homeTel;

    private String address;

    @Email(message = "Неправильно введет е-мейл")
    private String mail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "RecordForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobileTel='" + mobileTel + '\'' +
                ", homeTel='" + homeTel + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
