package org.example.calculatorhw;

import org.example.calculatorhw.Exceptions.DivisionByZeroException;
import org.example.calculatorhw.Service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testPlus() {
        assertEquals(10, calculatorService.plus(5.0, 5.0));
        assertEquals(0, calculatorService.plus(-5.0, 5.0));
    }

    @Test
    public void testMinus() {
        assertEquals(0, calculatorService.minus(5.0, 5.0));
        assertEquals(-10.0, calculatorService.minus(-5.0, 5.0));
    }

    @Test
    public void testMultiply() {
        assertEquals(25, calculatorService.multiply(5.0, 5.0));
        assertEquals(-25, calculatorService.multiply(-5.0, 5.0));
    }

    @Test
    public void testDivide() {
        assertEquals(1, calculatorService.divide(5.0, 5.0));
        assertEquals(-1, calculatorService.divide(-5.0, 5.0));
    }

    @Test
    public void divideByZero() {
        Exception exception = assertThrows(DivisionByZeroException.class, ()->{
            calculatorService.divide(5.0, 0.0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }
}
