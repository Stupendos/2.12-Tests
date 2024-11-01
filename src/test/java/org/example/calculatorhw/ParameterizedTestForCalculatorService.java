package org.example.calculatorhw;

import org.example.calculatorhw.Service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestForCalculatorService {
    private final CalculatorService calculatorService = new CalculatorService();

    static Stream<org.junit.jupiter.params.provider.Arguments> multiplyData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(2.0, 10.0, 20.0),
                org.junit.jupiter.params.provider.Arguments.of(3.0, 5.0, 15.0),
                org.junit.jupiter.params.provider.Arguments.of(10.0, 0.0, 0.0)
        );
    }
        @ParameterizedTest
        @MethodSource("multiplyData")
        public void testMultiply (Double a, double b, double expected){
            assertEquals(expected, calculatorService.multiply(a, b));
        }

    static Stream<org.junit.jupiter.params.provider.Arguments> divideData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(2.0, 10.0, 0.2),
                org.junit.jupiter.params.provider.Arguments.of(3.0, 5.0, 0.6),
                org.junit.jupiter.params.provider.Arguments.of(10.0, 2.0, 5.0)
        );
    }
    @ParameterizedTest
    @MethodSource("divideData")
    public void testDivide (Double a, double b, double expected){
        assertEquals(expected, calculatorService.divide(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> plusData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(2.0, 10.0, 12.0),
                org.junit.jupiter.params.provider.Arguments.of(3.0, 5.0, 8.0),
                org.junit.jupiter.params.provider.Arguments.of(10.0, 0.0, 10.0)
        );
    }
    @ParameterizedTest
    @MethodSource("plusData")
    public void testPlus (Double a, double b, double expected){
        assertEquals(expected, calculatorService.plus(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> minusData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(2.0, 10.0, -8.0),
                org.junit.jupiter.params.provider.Arguments.of(3.0, 5.0, -2.0),
                org.junit.jupiter.params.provider.Arguments.of(10.0, 0.0, 10.0)
        );
    }
    @ParameterizedTest
    @MethodSource("minusData")
    public void testMinus (Double a, double b, double expected){
        assertEquals(expected, calculatorService.minus(a, b));
    }
    }
