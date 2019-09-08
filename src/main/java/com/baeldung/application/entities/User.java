package com.baeldung.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String email;
    private final String adresse;
    
    public User() {
        this.name = "";
        this.adresse = "";
        this.email = "";
    }
    
    public User(String name, String adresse, String email) {
        this.name = name;
        this.adresse = adresse;
        this.email = email;
    }



    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", adresse=" + adresse + ", email=" + email + '}';
    }
}
