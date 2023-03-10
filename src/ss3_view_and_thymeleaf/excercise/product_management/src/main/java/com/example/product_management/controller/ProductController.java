package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.getListProduct());
        return "home";
    }
    @GetMapping("/showUpdate/{name}")
    public String showFormUpdate(@PathVariable String name, Model model){
        model.addAttribute("product", productService.findByName(name));
        return "update";
    }

    @GetMapping("/showAdd")
    public String showFormAdd(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String showAdd(Product product, RedirectAttributes redirectAttributes){
        if (productService.addProduct(product)) {
             redirectAttributes.addFlashAttribute("message", "Add success^^");
             return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Add failed :(");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        return new ModelAndView("view", "product", productService.findById(id));
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        if (productService.updateProduct(product.getId(), product)) {
            redirectAttributes.addFlashAttribute("message", "Update success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Update failed :(");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (productService.deleteProduct(Integer.parseInt(request.getParameter("idDelete")))) {
            redirectAttributes.addFlashAttribute("message", "Delete success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Delete failed :(");
        return "redirect:/product";
    }

    @PostMapping("/find")
    public ModelAndView findByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        ArrayList<Product> products = new ArrayList<>();
        products.add(productService.findByName(name));
        return new ModelAndView("home", "products", products);
    }
}
