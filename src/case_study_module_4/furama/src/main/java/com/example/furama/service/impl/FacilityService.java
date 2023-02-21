package com.example.furama.service.impl;
import com.example.furama.model.Facility;
import com.example.furama.repository.IFacilityRepository;
import com.example.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> searchByName(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Facility> searchByNameAndFacilityType(String name, int facilityTypeId, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType_Id(name, facilityTypeId, pageable);
    }

    @Override
    public boolean addOrUpdate(Facility facility) {
        try {
            facilityRepository.save(facility);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(int idDelete) {
        try {
            facilityRepository.deleteById(idDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
