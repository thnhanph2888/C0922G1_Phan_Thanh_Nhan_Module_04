package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    @ManyToMany(mappedBy = "attachFacilitySet")
    private Set<Contract> contractSet;

    public AttachFacility() {
    }

    public AttachFacility(String id, String name, Set<Contract> contractSet) {
        this.id = id;
        this.name = name;
        this.contractSet = contractSet;
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

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
