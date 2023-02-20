package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String name;
    @OneToMany(mappedBy = "customerType", cascade = CascadeType.REMOVE)
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
