package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("customer", customerService);
        return "/customer/home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/add";
    }

    @PostMapping("/save")
    public String addOrUpdate(Customer customer, @RequestParam("action") String action, RedirectAttributes redirectAttributes){
        customerService.addOrUpdate(customer);
        if (action.equals("add")) {
            redirectAttributes.addFlashAttribute("message", "add success!");
        } else {
            redirectAttributes.addFlashAttribute("message", "update success");
        }
        return "redirect:/";
    }
}
