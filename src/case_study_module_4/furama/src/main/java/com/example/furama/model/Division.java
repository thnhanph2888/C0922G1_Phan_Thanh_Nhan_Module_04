package com.example.furama.model;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
public class Division {
    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String name;
    @OneToMany(mappedBy = "division", cascade = CascadeType.REMOVE)
    private Set<Employee> employeeSet;

    public Division() {
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
