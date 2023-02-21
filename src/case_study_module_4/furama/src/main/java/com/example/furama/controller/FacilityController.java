package com.example.furama.controller;

import com.example.furama.dto.FacilityDto;
import com.example.furama.model.Facility;
import com.example.furama.repository.IFacilityTypeRepository;
import com.example.furama.service.IFacilityService;
import com.example.furama.service.IFacilityTypeService;
import com.example.furama.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;
    @ModelAttribute
    public void AddListFacilityType(Model model) {
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
    }
    @ModelAttribute
    public void AddListRentType(Model model) {
        model.addAttribute("rentTypes", rentTypeService.findAll());
    }
    @GetMapping("")
    public String searchByNameAndFacilityType(Model model
            , @RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "size", defaultValue = "5") int size
            , @RequestParam(value = "name", defaultValue = "%%") String nameSearch
            , @RequestParam(value = "facilityTypeId", defaultValue = "%%") String facilityTypeId) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityTypeId", facilityTypeId);
        model.addAttribute("facilityList",  facilityService.searchByNameAndFacilityType(nameSearch, facilityTypeId, pageable));
        return "facility/list";
    }

    @GetMapping("showAdd")
    public String showAdd(Model model) {
        model.addAttribute("facility", new FacilityDto());
        return "facility/add_facility";
    }

    @PostMapping("/save")
    public String addOrUpdate(FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        if (facilityService.addOrUpdate(facility)) {
            redirectAttributes.addFlashAttribute("message", "success!");
        } else {
            redirectAttributes.addFlashAttribute("message", "failed!");
        }
        return "redirect:/facility";
    }
}
