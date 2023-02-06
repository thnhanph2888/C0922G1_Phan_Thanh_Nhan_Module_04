package com.example.product_management_jpa.controller;
import com.example.product_management_jpa.model.Product;
import com.example.product_management_jpa.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "home";
    }
    @GetMapping("/showUpdate/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @GetMapping("/showAdd")
    public String showFormAdd(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String showAdd(Product product, RedirectAttributes redirectAttributes){
        if (productService.add(product)) {
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
        if (productService.update(product)) {
            redirectAttributes.addFlashAttribute("message", "Update success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Update failed :(");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (productService.delete(Integer.parseInt(request.getParameter("idDelete")))) {
            redirectAttributes.addFlashAttribute("message", "Delete success ^^");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Delete failed :(");
        return "redirect:/product";
    }

    @PostMapping("/find")
    public ModelAndView findByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<Product> products = productService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("home", "products", products);
        if (products == null) {
            modelAndView.addObject("message", "Không có dữ liệu");
        }
        return modelAndView;
    }
}
