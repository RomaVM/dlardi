package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roma on 03.03.2017.
 */

@Entity(name = "Client")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "login")
    private String login;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Record> records = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public List<Record> getRecords() {
        return records;
    }

    public void addRecord(Record record) {
        this.records.add(record);
        record.setClient(this);
    }

    public void removeRecord(Record record) {
        this.records.remove(record);
        record.setClient(null);
    }
}
