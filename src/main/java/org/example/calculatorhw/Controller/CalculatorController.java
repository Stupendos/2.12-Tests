package org.example.calculatorhw.Controller;

import org.example.calculatorhw.Exceptions.DivisionByZeroException;
import org.example.calculatorhw.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Calculator!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        if (num2 == 0) {
            throw new DivisionByZeroException("Division by zero");
        } else {
            double result = calculatorService.divide(num1, num2);
            return num1 + " / " + num2 + " = " + result;
        }
    }

    private void validateParameters(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Оба параметра должны быть указаны.");
        }
    }
}
