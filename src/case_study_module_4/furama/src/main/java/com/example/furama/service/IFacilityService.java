package com.example.furama.service;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> searchByNameAndFacilityType(String name, String facilityTypeId, Pageable pageable);
    boolean addOrUpdate(Facility facility);
}
