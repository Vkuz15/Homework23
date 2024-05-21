package pro.sky.JavaSkyPro.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.JavaSkyPro.exception.DivideNotNullException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void calculatorStart() {
    }

    @Test
    void sum() {
        Assertions.assertEquals(10, calculatorService.sum(5, 5));
        Assertions.assertEquals(0, calculatorService.sum(5, -5));
    }

    @Test
    void minus() {
        Assertions.assertEquals(5, calculatorService.minus(10, 5));
        Assertions.assertEquals(4, calculatorService.minus(8, 4));
    }

    @Test
    void multiply() {
        Assertions.assertEquals(4, calculatorService.multiply(2, 2));
        Assertions.assertEquals(16, calculatorService.multiply(4, 4));
    }

    @Test
    void divide() {
        Assertions.assertEquals(4, calculatorService.divide(8, 2));
        Assertions.assertEquals(2, calculatorService.divide(4, 2));
        Assertions.assertThrows(DivideNotNullException.class, () -> calculatorService.divide(10, 0));
    }

    @MethodSource("calculatorSumTests")
    @ParameterizedTest
    public void shouldResultOfSum(int num1, int num2) {
        assertEquals(num1 + num2, calculatorService.sum(num1, num2));
    }

    private static Stream<Arguments> calculatorSumTests() {
        return Stream.of(
                Arguments.of(1, 4),
                Arguments.of(5, 6)
        );
    }

    @MethodSource("calculatorMinusTests")
    @ParameterizedTest
    public void shouldResultOfMinus(int num1, int num2) {
        assertEquals(num1 - num2, calculatorService.minus(num1, num2));
    }

    private static Stream<Arguments> calculatorMinusTests() {
        return Stream.of(
                Arguments.of(4, 5),
                Arguments.of(5, 1)
        );
    }

    @MethodSource("calculatorMultiplyTests")
    @ParameterizedTest
    public void shouldResultOfMultiply(int num1, int num2) {
        assertEquals(num1 * num2, calculatorService.multiply(num1, num2));
    }

    private static Stream<Arguments> calculatorMultiplyTests() {
        return Stream.of(
                Arguments.of(5, 6),
                Arguments.of(7, 5)
        );
    }

    @MethodSource("calculatorDivideTests")
    @ParameterizedTest
    public void shouldResultOfDivide(int num1, int num2) {
        assertEquals(num1 / num2, calculatorService.divide(num1, num2));
    }

    private static Stream<Arguments> calculatorDivideTests() {
        return Stream.of(
                Arguments.of(10, 2),
                Arguments.of(15, 5)
        );
    }
}