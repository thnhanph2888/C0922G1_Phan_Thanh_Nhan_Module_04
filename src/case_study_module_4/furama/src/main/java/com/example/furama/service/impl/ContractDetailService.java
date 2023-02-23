package com.example.furama.service.impl;

import com.example.furama.model.ContractDetail;
import com.example.furama.repository.IContractDetailRepository;
import com.example.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public boolean save(ContractDetail contractDetail) {
      try {
          contractDetailRepository.save(contractDetail);
          return true;
      } catch (Exception e) {
          return false;
      }
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }
}
