package com.example.furama.service;

import com.example.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    boolean addContractDetail(int attachId, int quality, int contractId);
    boolean save(ContractDetail contractDetail);
    Page<ContractDetail> findAll(Pageable pageable);
}
