package com.adi.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Process {

    @Id
    private String id;
    private final String businesskey;

    public Process() {
        this.id = "";
        this.businesskey = "";
    }

    public Process(String id, String businesskey) {
        this.id = id;
        this.businesskey = businesskey;
    }

    public String getId() {
        return id;
    }

    public String getbusinesskey() {
        return businesskey;
    }

    @Override
    public String toString() {
        return "Process{" + "id=" + id + ", businesskey=" + businesskey +  "}";
    }
}
