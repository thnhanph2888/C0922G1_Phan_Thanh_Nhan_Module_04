package com.example.furama.repository;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(nativeQuery = true, value = "select * from facility where facility.name like :name and facility.facility_type_id like :facilityTypeId")
    Page<Facility> searchByNameAndFacilityType(@Param("name") String name, @Param("facilityTypeId") String facilityTypeId, Pageable pageable);
}
