package com.example.furama.controller;
import com.example.furama.dto.ContractDto;
import com.example.furama.model.Contract;
import com.example.furama.model.ContractDetail;
import com.example.furama.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @ModelAttribute
    public void addListAttachFacility(Model model) {
        model.addAttribute("listAttachFacility", attachFacilityService.findAll());
    }

    @ModelAttribute
    public void addListEmployee(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
    }

    @ModelAttribute
    public void addListCustomer(Model model) {
        model.addAttribute("customerList", customerService.findAll());
    }

    @ModelAttribute
    public void addListFacility(Model model) {
        model.addAttribute("facilityList", facilityService.findAll());
    }

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("contractDtoList", contractService.findAllContractDto(pageable));
        return "/contract/list_contract";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/add_contract";
    }

    @PostMapping("/save")
    public String addOrUpdate(@Validated ContractDto contractDto
            , BindingResult bindingResult
            , Model model
            , RedirectAttributes redirectAttributes
            , @RequestParam(value = "listIdAttach", defaultValue = "") List<Integer> listId
            , @RequestParam(value = "listQuality", defaultValue = "") List<Integer> listQuality) {
        if (bindingResult.hasErrors()) {
           model.addAttribute("contractDto", contractDto);
           return "contract/add_contract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        if (contractService.save(contract)) {
            redirectAttributes.addFlashAttribute("message", "add contract success!");
        } else {
            redirectAttributes.addFlashAttribute("message", "add contract failed!");
        }
        if (listId.size() > 0) {
            addContractDetail(listId, listQuality, contract.getId());
        }
        return ("redirect:/contract");
    }

    public void addContractDetail(List<Integer> listId, List<Integer> listQuality, int idContract) {
        for (int i = 0; i < listId.size(); i++) {
            contractDetailService.save(new ContractDetail(attachFacilityService.findById(listId.get(i))
                    , contractService.findById(idContract), listQuality.get(i)));
        }
    }
}
