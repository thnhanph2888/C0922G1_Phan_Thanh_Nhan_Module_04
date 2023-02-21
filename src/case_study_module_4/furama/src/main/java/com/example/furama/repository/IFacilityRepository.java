package com.example.furama.repository;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findByNameContaining(String name, Pageable pageable);
    Page<Facility> findByNameContainingAndFacilityType_Id(String name, int facilityTypeId, Pageable pageable);
}
