package com.example.furama.dto;

import com.example.furama.model.Contract;
import com.example.furama.model.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CustomerDto {
    private int id;
    @NotBlank(message = "Vui lòng nhập tên!")
    private String name;
    private String dayOfBirth;
    private Boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;

    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private Set<Contract> contractSet;

    public CustomerDto() {
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

    public String getBirthday() {
        return dayOfBirth;
    }

    public void setBirthday(String birthday) {
        this.dayOfBirth = birthday;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}

