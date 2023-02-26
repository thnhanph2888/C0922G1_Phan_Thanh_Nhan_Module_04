package com.example.furama.dto;

import com.example.furama.model.Contract;
import com.example.furama.model.CustomerType;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto {
    private int id;
    @NotBlank(message = "Vui lòng nhập tên!")
    @Pattern(regexp = "^[A-Z]\\D*$", message = "Chữ cái đầu tiên của tên phải viết hoa và tên không được viết số")
    private String name;
    private String dayOfBirth;
    private Boolean gender;
    @NotBlank(message = "Vui lòng nhập số chứng minh nhân dân!")
    @Pattern(regexp = "^([0-9]{12})$|^([0-9]{9})$", message = "Số CMND chỉ được chứa 0-9 và phải 9 số hoặc 12")
    private String idCard;
    @NotBlank(message = "Vui lòng nhập số điện thoại!")
    @Pattern(regexp = "\"((09[1|0])|([(]84[)][+]9[1|0]))[0-9]{7}$\"g", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;
    @NotBlank(message = "Vui lòng nhập email!")
    @Pattern(regexp = "\"^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$\"g", message = "Email chưa đúng định dạng ")
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

