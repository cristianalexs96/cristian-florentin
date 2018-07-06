package com.Topic1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void TestSubstraction() {
        Calculator calculator = new Calculator();
        int result = calculator.Substraction(5,3);
        int expectedresult = 2;
        assertEquals(result, expectedresult);
    }

    @Test
    void TestSum() {
        Calculator calculator = new Calculator();
        int result = calculator.Sum(5,5);
        int expectedresult = 10;
        assertEquals(result, expectedresult);

    }
}
