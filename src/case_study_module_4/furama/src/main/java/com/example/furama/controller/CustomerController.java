package com.example.furama.controller;

import com.example.furama.dto.CustomerDto;
import com.example.furama.model.Customer;
import com.example.furama.service.ICustomerService;
import com.example.furama.service.ICustomerTypeService;
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

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
    }

    @GetMapping("")
    public String searchByNameAndEmailAndCustomerType(
            @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch
            , @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch
            , @RequestParam(value = "customerTypeId", defaultValue = "0") int customerTypeId
            , Model model
            , @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        if (customerTypeId != 0) {
            model.addAttribute("customers", customerService.searchByNameAndEmailAndCustomerType(pageable
                    , nameSearch, emailSearch, customerTypeId));
        } else {
            model.addAttribute("customers", customerService.findByNameAndEmail(nameSearch, emailSearch, pageable));
        }
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeId", customerTypeId);
        return "/customer/home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add_customer";
    }

    @PostMapping("/save")
    public String addOrUpdate(@Validated CustomerDto customerDto
            , BindingResult bindingResult
            ,Model model
            , @RequestParam(value = "action", defaultValue = "add") String action
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/add_customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (customerService.addOrUpdate(customer)) {
            if (action.equals("add")) {
                redirectAttributes.addFlashAttribute("message", "add success!");
            } else {
                redirectAttributes.addFlashAttribute("message", "update success");
            }
        } else {
            if (action.equals("add")) {
                redirectAttributes.addFlashAttribute("message", "add failed!");
            } else {
                redirectAttributes.addFlashAttribute("message", "update failed!");
            }
        }
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int idDelete, RedirectAttributes redirectAttributes) {
        if (customerService.delete(idDelete)) {
            redirectAttributes.addFlashAttribute("message", "Delete success!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete failed!");
        }
        return "redirect:/customer";
    }

    @GetMapping("/update/{idUpdate}")
    public String showUpdate(@PathVariable int idUpdate, Model model) {
        model.addAttribute("customer", customerService.findById(idUpdate));
        return "customer/update_customer";
    }
}
