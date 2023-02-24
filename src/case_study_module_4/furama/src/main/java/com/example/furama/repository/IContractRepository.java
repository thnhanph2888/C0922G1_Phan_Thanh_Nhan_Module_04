package com.example.furama.repository;

import com.example.furama.dto.IContractDto;
import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(nativeQuery = true, value = "select (af.cost * cd.quality) + fc.cost as costs, ct.* \n" +
            "from contract ct \n" +
            "join contract_detail cd on ct.id = cd.contract_id\n" +
            "join attach_facility af on cd.attach_facility_id = af.id\n" +
            "join facility fc on fc.id = ct.facility_id\n" +
            "where ct.id = :idContract ")
    double getCurrentTotalMoney(@Param("idContract") int id);

    @Query(nativeQuery = true, value = "select fc.cost + (af.cost * :quality) from facility fc\n" +
            "join attach_facility af where fc.id = :facilityId and af.id = :attachFacilityId")
    double getTotalMoneyAdd(@RequestParam("quality") int quality
            , @RequestParam("attachFacilityId") int attachFacilityId
            , @RequestParam("facilityId") int facilityId);
    @Query(nativeQuery = true, value = "select facility.cost from `facility` where facility.id = :facilityId")
    double getTotalMoneyFacility(@RequestParam("facilityId") int facilityId);

    @Query(nativeQuery = true, value = "select `contract`.id as idContract,`contract`.start_date as startDate\n" +
            ", `contract`.end_date as endDate, `contract`.deposit as deposit, `facility`.name as facilityName\n" +
            ", `customer`.name as customerName,  (ifnull(`facility`.cost,0)+ (ifnull(`contract_detail`.quality,0) * ifnull( `attach_facility`.cost,0))) as totalMoney \n" +
            "             from `contract`\n" +
            "             left join `facility` on `facility`.id = `contract`.facility_id\n" +
            "             left join `contract_detail` on `contract`.id = `contract_detail`.contract_id\n" +
            "             left join `attach_facility` on `attach_facility`.id = `contract_detail`.attach_facility_id\n" +
            "             left join `customer` on `customer`.id = `contract`.customer_id", countQuery = "select `contract`.id as idContract,`contract`.start_date as startDate\n\" +\n" +
            "            \", `contract`.end_date as endDate, `contract`.deposit as deposit, `facility`.name as facilityName\n\" +\n" +
            "            \", `customer`.name as customerName,  (ifnull(`facility`.cost,0)+ (ifnull(`contract_detail`.quality,0) * ifnull( `attach_facility`.cost,0))) as totalMoney \n\" +\n" +
            "            \"             from `contract`\n\" +\n" +
            "            \"             left join `facility` on `facility`.id = `contract`.facility_id\n\" +\n" +
            "            \"             left join `contract_detail` on `contract`.id = `contract_detail`.contract_id\n\" +\n" +
            "            \"             left join `attach_facility` on `attach_facility`.id = `contract_detail`.attach_facility_id\n\" +\n" +
            "            \"             left join `customer` on `customer`.id = `contract`.customer_id")
    Page<IContractDto> findAllContract(Pageable pageable);
}
