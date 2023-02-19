package com.example.furama.model;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    @OneToMany(mappedBy = "division", cascade = CascadeType.REMOVE)
    private Set<Employee> employeeSet;

    public Division() {
    }

    public Division(String id, String name, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.employeeSet = employeeSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
