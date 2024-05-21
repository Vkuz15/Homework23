package pro.sky.JavaSkyPro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.JavaSkyPro.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String calculatorStart() {
        return calculatorService.calculatorStart();
    }

    @GetMapping("/plus")
    public String sumNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Неверные данные</h1>";
        }
        int result = calculatorService.sum(num1, num2);
        return generateMessage(num1, num2, '+', result);
    }

    @GetMapping("/minus")
    public String minusNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Неверные данные</h1>";
        }
        int result = calculatorService.minus(num1, num2);
        return generateMessage(num1, num2, '-', result);
    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Неверные данные</h1>";
        }
        int result = calculatorService.multiply(num1, num2);
        return generateMessage(num1, num2, '*', result);
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Неверные данные</h1>";
        }
        int result = calculatorService.divide(num1, num2);
        return generateMessage(num1, num2, '/', result);
    }

    private String generateMessage(int num1, int num2, char action, int result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, action, num2, result);
    }
}

