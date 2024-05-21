package pro.sky.JavaSkyPro.service;

import org.springframework.stereotype.Service;
import pro.sky.JavaSkyPro.exception.DivideNotNullException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calculatorStart() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DivideNotNullException();
        }
        return num1 / num2;
    }
}

