package com.example.furama.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private String startDate;
    private String endDate;
    private String deposit;
    private String totalMoney;
    @ManyToMany
    @JoinTable(name = "contract_detail"
            , joinColumns = @JoinColumn(name = "contract_id")
            , inverseJoinColumns = @JoinColumn(name = "attach_facility_id"))
    private Set<AttachFacility> attachFacilitySet;
    private String nameFacility;
    private String nameCustomer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public Contract() {
    }

    public Contract(String id, Facility facility, Customer customer, String startDate, String endDate, String deposit, String totalMoney, Set<AttachFacility> attachFacilitySet, String nameFacility, String nameCustomer, Employee employee) {
        this.id = id;
        this.facility = facility;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.attachFacilitySet = attachFacilitySet;
        this.nameFacility = nameFacility;
        this.nameCustomer = nameCustomer;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Set<AttachFacility> getAttachFacilitySet() {
        return attachFacilitySet;
    }

    public void setAttachFacilitySet(Set<AttachFacility> attachFacilitySet) {
        this.attachFacilitySet = attachFacilitySet;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
