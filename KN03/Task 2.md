# Task 2 – JUnit 5 Summary

JUnit is a testing framework used to automatically test Java applications.It helps us developers to verify what methods behave correctly and detect errors early.


## 1. @Test Annotation

Marks a method as a test case.

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    @Test
    void addTest() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2,3));
    }

## 2. Assertions
Assertions compare expected and actual results. Some common assertions:
- assertEquals(expected, actual)
- assertTrue(condition)
- assertFalse(condition)
- assertThrows(Exception.class, executable)

      assertEquals(10, calc.multiply(2,5));
      assertTrue(calc.add(1,1) == 2);
      assertThrows(IllegalArgumentException.class, () -> calc.divide(5,0));

## 3. @BeforeEach Annotation
Runs before every test method to prepare objects.

    import org.junit.jupiter.api.BeforeEach;
    
    Calculator calc;
    
    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

## 4. Test Naming Convention
Test names should describe:
- method_condition_expectedResult
  
Examples:
- divide_byZero_shouldThrowException
- add_negativeNumbers_shouldReturnCorrectSum

## 5. Floating Point Tolerance
Used when comparing double values to avoid rounding errors.

    assertEquals(2.5, calc.divide(5,2), 0.0001);

## 6. Reference
Official JUnit 5 Documentation:
- https://junit.org/junit5/docs/current/user-guide/
