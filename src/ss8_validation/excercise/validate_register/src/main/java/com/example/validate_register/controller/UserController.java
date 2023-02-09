package com.example.validate_register.controller;
import com.example.validate_register.dto.UserDto;
import com.example.validate_register.model.User;
import com.example.validate_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    IUserService accountService;

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showRegister")
    public String showRegister(Model model) {
        model.addAttribute("userDto", new UserDto());
       return "register";
    }

    @PostMapping("/register")
    public String register(@Validated UserDto userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
              model.addAttribute("userDto", userDto);
               return "register";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        accountService.submit(user);
        model.addAttribute("message", "success");
        return "home";
    }
}
