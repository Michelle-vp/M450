# Exercises

## Exercise 1

We have the following description of a sales software:

> The car dealership can use the sales software to set discount rules for its salespeople:  
> For a purchase price of less than no discount is to be granted beyond CHF 15.000.  
> For a price of up to 20,000 CHF, e.5% discount is appropriate.  
> If the Purchase price below 25,000 CHF is possible 7% discount, above that 8.5% discount is to be granted.

### Task

Derive test cases from this description. We want to examine both variants of test cases.

- A table of abstract test cases. Here you use logical operators such as `>`, `<`, etc.
- A table with concrete test cases. Here you use very specific input values to create the test cases.

---

## Exercise 2

Find a website on the subject of car rental.

Define functional black-box tests that you need to run this platform.

List the 5 most important test cases.

Create a table with these test cases as Markdown and put it in your repository. Here is an idea as a table:

| ID | Description               | Expected result                                       | Effective result                         | Status | Possible cause                    |
|----|---------------------------|-------------------------------------------------------|------------------------------------------|--------|-----------------------------------|
| 1  | Program starts correctly  | After calling the program on the console, a window opens. | Program crashes with error X00234         | Errors | Access to DB server may not be possible |

---

## Exercise 3

You have the following software of a simple banking software. Download the source zip and create a local Project in your IDE. Attention! You also need to install the JAR files for GSON and OKHTTP. Alternatively, you can use the Maven project to get it up and running without the JAR Files. The software plus JAR files can be found here:  
https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/tree/main/Unterlagen/teststrategie

Familiarize yourself with the code.

We want to find out very roughly what kind of test cases there are in this software.

- The application is running with you and you can test it.
- Identify possible black-box tests that you as a user can test.
- What methods in the code could be used for white-box tests?
- What would you improve on the code in general, what best practices can you think of?

List your test cases in a table in a Markdown document and put your solution in your repository.

