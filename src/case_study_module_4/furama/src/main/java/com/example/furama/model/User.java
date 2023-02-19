package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Employee> employeeSet;
    @ManyToMany
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "username")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public User() {
    }

    public User(String userName, String password, Set<Employee> employeeSet, Set<Role> roleSet) {
        this.userName = userName;
        this.password = password;
        this.employeeSet = employeeSet;
        this.roleSet = roleSet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
