package ch.tbz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private CalculatorApp calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorApp();
    }

    @Test
    void add_shouldReturnSum() {
        assertEquals(5.0, calculator.add(2.0, 3.0));
    }

    @Test
    void add_shouldWorkWithNegativeNumbers() {
        assertEquals(-1.0, calculator.add(2.0, -3.0));
    }

    @Test
    void subtract_shouldReturnDifference() {
        assertEquals(1.0, calculator.subtract(4.0, 3.0));
    }

    @Test
    void multiply_shouldReturnProduct() {
        assertEquals(12.0, calculator.multiply(3.0, 4.0));
    }

    @Test
    void divide_shouldReturnQuotient() {
        assertEquals(2.0, calculator.divide(10.0, 5.0));
    }

    @Test
    void divide_byZeroShouldThrowException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10.0, 0.0)
        );
        assertEquals("Divisor must not be 0", ex.getMessage());
    }

    @Test
    void divide_shouldHandleDecimals() {
        assertEquals(2.5, calculator.divide(5.0, 2.0), 0.000001);
    }
}
