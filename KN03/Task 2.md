# Task 2 – JUnit 5 Summary

JUnit is a testing framework used to automatically test Java applications.It helps us developers to verify what methods behave correctly and detect errors early.


## 1. @Test Annotation

Marks a method as a test case.

`
  import org.junit.jupiter.api.Test;
  import static org.junit.jupiter.api.Assertions.*;
  
  @Test
  void addTest() {
      Calculator calc = new Calculator();
      assertEquals(5, calc.add(2,3));
  }
`

j
