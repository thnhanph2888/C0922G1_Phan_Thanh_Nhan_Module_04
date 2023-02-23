package com.example.furama.repository;

import com.example.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    ContractDetail findByAttachFacility_IdAndAndContract_Id(int attachFacilityId, int contractId);
}
