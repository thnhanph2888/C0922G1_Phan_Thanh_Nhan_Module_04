package com.example.furama.controller;

import com.example.furama.model.AttachFacility;
import com.example.furama.model.Contract;
import com.example.furama.model.ContractDetail;
import com.example.furama.service.IAttachFacilityService;
import com.example.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestContractDetailController {
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractService contractService;

    @GetMapping("/getListAttachFacility")
    public ResponseEntity<List<AttachFacility>> getListAttachFacility() {
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        if (attachFacilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
        }
    }

    @GetMapping("/getListAttachFacilityByContract")
    public ResponseEntity<List<AttachFacility>> getListAttachFacilityByContract(@RequestParam("idContract") int idContract) {
        Contract contract = contractService.findById(idContract);
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        for (ContractDetail contractDetail : contract.getContractDetailSet()) {
            attachFacilityList.add(contractDetail.getAttachFacility());
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }

    @GetMapping("/getCurrentTotalMoney")
    public ResponseEntity<Double> getCurrentTotalMoney(@RequestParam("idContract") int idContract) {
        double totalMoney = contractService.getCurrentTotalMoney(idContract);
        return new ResponseEntity<>(totalMoney, HttpStatus.OK);
    }

    @GetMapping("/getCurrentTotalMoneyAdd")
    public ResponseEntity<Double> getCurrentTotalMoneyAdd(@RequestParam("quality") int quality
            , @RequestParam("attachFacilityId") int attach_facility_id
            , @RequestParam("facilityId") int facilityId) {
        double totalMoney = contractService.getCurrentTotalAdd(quality, attach_facility_id, facilityId);
        return new ResponseEntity<>(totalMoney, HttpStatus.OK);
    }
}
