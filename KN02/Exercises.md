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
  
| ID | Purchase price condition | Expected discount |
|----|--------------------------|------------------|
| A1 | `price < 15000`          | 0%               |
| A2 | `15000 ≤ price ≤ 20000`  | 5%               |
| A3 | `20000 < price < 25000`  | 7%               |
| A4 | `price ≥ 25000`          | 8.5%             |

- A table with concrete test cases. Here you use very specific input values to create the test cases.
  
| ID | Purchase price (CHF) | Reason for selection           | Expected discount |
|----|----------------------|--------------------------------|------------------|
| C1 | 14'999               | Just below the minimum of 5%   | 0%               |
| C2 | 15'000               | Exactly minimum price 5%       | 5%               |
| C3 | 16'000               | Middle of range of 5%          | 5%               |
| C4 | 20'000               | Exactly maximum price 5%       | 5%               |
| C5 | 20'001               | Just above the minimum of 7%   | 7%               |
| C6 | 22'000               | Middle of range of 7%          | 7%               |
| C7 | 24'999               | Just below the minimum of 8.5% | 7%               |
| C8 | 25'000               | Exactly minimum price 8.5%     | 8.5%             |
| C9 | 30'000               | In range of 8.5%               | 8.5%             |

---

## Exercise 2

Find a website on the subject of car rental.

Define functional black-box tests that you need to run this platform.

List the 5 most important test cases.

Create a table with these test cases as Markdown and put it in your repository. Here is an idea as a table:

| ID | Description               | Expected result                                       | Effective result                         | Status | Possible cause                    |
|----|---------------------------|-------------------------------------------------------|------------------------------------------|--------|-----------------------------------|
| 1  | Program starts correctly  | After calling the program on the console, a window opens. | Program crashes with error X00234         | Errors | Access to DB server may not be possible |

Used: Enterprise Rent-A-Car
Table:

| ID | Description | Expected result | Effective result | Status | Possible cause |
|----|------------|-----------------|------------------|--------|----------------|
| 1 | Search for available cars with valid input | After entering a valid pickup location, pickup date/time and return date/time, a list of available vehicles with prices is displayed. | Available vehicle categories with prices were shown correctly. | Pass | — |
| 2 | Validate incorrect date input | If the return date/time is earlier than the pickup date/time, the system should display an error message and prevent the search. | An error message was displayed and the search could not be continued. | Pass | — |
| 3 | Price calculation with extras | When adding optional extras (e.g. child seat), the total price should update correctly and display all costs transparently. | The total price updated immediately and all costs were shown correctly. | Pass | — |
| 4 | Complete booking process | After entering customer details and confirming the booking, a confirmation page with a reservation number should be displayed. | Booking was completed successfully and a confirmation with reservation number was shown. | Pass | — |
| 5 | View or cancel an existing reservation | Using the reservation number and personal details, the user should be able to view and cancel a reservation. | Reservation was found and cancellation option was available and worked. | Pass | — |

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

