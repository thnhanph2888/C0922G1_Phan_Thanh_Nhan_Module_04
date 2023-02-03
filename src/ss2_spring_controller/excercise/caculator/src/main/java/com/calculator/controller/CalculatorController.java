package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {


    @GetMapping("")
    public String showHome() {
        return "home";
    }

    @PostMapping("calculate")
    public ModelAndView calculate(@RequestParam("calculation") String calculation, @RequestParam("firstNumber") double firstNumber, @RequestParam("secondNumber") double secondNumber) {
        double resultCalculator = 0;
        String result = "Không được chia cho 0";
        switch (calculation) {
            case "+":
                resultCalculator = firstNumber + secondNumber;
                break;
            case "-":
                resultCalculator = firstNumber - secondNumber;
                break;
            case "*":
                resultCalculator = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    return new ModelAndView("home", "result", result);
                }
                    resultCalculator = firstNumber / secondNumber;
                break;
            default:
                return new ModelAndView("home", "result", "không hỗ trợ phép tính này");
        }
         result = String.valueOf(resultCalculator);
        return new ModelAndView("home", "result", result);
    }
}
