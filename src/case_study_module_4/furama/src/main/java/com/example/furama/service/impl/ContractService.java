package com.example.furama.service.impl;

import com.example.furama.dto.IContractDto;
import com.example.furama.model.Contract;
import com.example.furama.repository.IContractRepository;
import com.example.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public boolean save(Contract contract) {
        contractRepository.save(contract);
        try {
            contractRepository.save(contract);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Double getCurrentTotalMoney(int idContract) {
        return contractRepository.getCurrentTotalMoney(idContract);
    }

    @Override
    public Double getCurrentTotalFacility(int idFacility) {
        return contractRepository.getTotalMoneyFacility(idFacility);
    }

    @Override
    public double getCurrentTotalAdd(int quality, int attachFacilityId, int facilityId) {
        return contractRepository.getTotalMoneyAdd(quality, attachFacilityId, facilityId);
    }

    @Override
    public Page<IContractDto> findAllContractDto(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }
}
