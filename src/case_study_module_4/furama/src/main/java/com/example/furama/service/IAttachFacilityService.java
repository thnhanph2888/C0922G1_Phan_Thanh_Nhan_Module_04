package com.example.furama.service;

import com.example.furama.model.AttachFacility;
import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    AttachFacility findById(int id);
}
