package com.example.furama.service;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> searchByName(String name, Pageable pageable);
    Page<Facility> searchByNameAndFacilityType(String name, int facilityTypeId, Pageable pageable);
    boolean addOrUpdate(Facility facility);
    boolean deleteById(int idDelete);
    Facility findById(int id);

    List<Facility> findAll();
}
