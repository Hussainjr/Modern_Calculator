package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute CalculatorRequestDTO requestDTO, Model model) {
        double result = calculatorService.add(requestDTO.getNumber1(), requestDTO.getNumber2());
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        responseDTO.setResult(result);
        responseDTO.setOperation("Addition");
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        return "index";
    }

    @PostMapping("/subtract")
    public String subtract(@ModelAttribute CalculatorRequestDTO requestDTO, Model model) {
        double result = calculatorService.subtract(requestDTO.getNumber1(), requestDTO.getNumber2());
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        responseDTO.setResult(result);
        responseDTO.setOperation("Subtraction");
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        return "index";
    }

    @PostMapping("/multiply")
    public String multiply(@ModelAttribute CalculatorRequestDTO requestDTO, Model model) {
        double result = calculatorService.multiply(requestDTO.getNumber1(), requestDTO.getNumber2());
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        responseDTO.setResult(result);
        responseDTO.setOperation("Multiplication");
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        return "index";
    }

    @PostMapping("/divide")
    public String divide(@ModelAttribute CalculatorRequestDTO requestDTO, Model model) {
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        try {
            double result = calculatorService.divide(requestDTO.getNumber1(), requestDTO.getNumber2());
            responseDTO.setResult(result);
            responseDTO.setOperation("Division");
        } catch (ArithmeticException e) {
            responseDTO.setError(e.getMessage());
        }
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        model.addAttribute("error", responseDTO.getError());
        return "index";
    }

    @RequestMapping(value = "/add/{a}/{b}", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public String addPath(@PathVariable double a, @PathVariable double b, Model model) {
        double result = calculatorService.add(a, b);
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        responseDTO.setResult(result);
        responseDTO.setOperation("Addition");
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        return "index";
    }

    @RequestMapping(value = "/subtract", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public String subtractRequestParam(@RequestParam double number1, @RequestParam double number2, Model model) {
        double result = calculatorService.subtract(number1, number2);
        CalculatorResponseDTO responseDTO = new CalculatorResponseDTO();
        responseDTO.setResult(result);
        responseDTO.setOperation("Subtraction");
        model.addAttribute("result", responseDTO.getResult());
        model.addAttribute("operation", responseDTO.getOperation());
        return "index";
    }
} 