package com.example.furama.repository;

import com.example.furama.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(nativeQuery = true, value = " INSERT INTO `contract_detail` (contract_id, attach_facility_id, quality) VALUES (:idContract, :attachId, :quality)")
    void addContractDetail(@Param("attachId") int attachId,@Param("quality") int quality,@Param("idContract") int idContract);
}
