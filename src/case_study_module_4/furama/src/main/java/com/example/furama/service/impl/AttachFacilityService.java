package com.example.furama.service.impl;

import com.example.furama.model.AttachFacility;
import com.example.furama.repository.IAttachFacilityRepository;
import com.example.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }
}
