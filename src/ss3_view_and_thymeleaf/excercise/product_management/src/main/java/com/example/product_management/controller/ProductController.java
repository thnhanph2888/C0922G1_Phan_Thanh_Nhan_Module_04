package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        if (productService.updateProduct(product.getId(), product)) {
            redirectAttributes.addFlashAttribute("success", "Update success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("success", "Update failed :(");
        return "redirect:/product";
    }

    @PostMapping("delete/{idDelete}")
    public String deleteProduct(@PathVariable int idDelete, RedirectAttributes redirectAttributes) {
        if (productService.deleteProduct(idDelete)) {
            redirectAttributes.addFlashAttribute("success", "Delete success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("success", "Delete failed :(");
        return "redirect:/product";
    }
}
