package com.example.furama.service;

import com.example.furama.dto.IContractDto;
import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    boolean save(Contract contract);
    Contract findById(int id);
    Double getCurrentTotalMoney(int idContract);
    Double getCurrentTotalFacility(int idFacility);
    double getCurrentTotalAdd(int quality, int attachFacilityId, int facilityId);

    Page<IContractDto> findAllContractDto(Pageable pageable);
}
