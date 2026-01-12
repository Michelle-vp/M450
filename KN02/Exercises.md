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
- Black-box tests:
  
| ID | Feature | Test steps / input | Expected result | Results|
|---:|--------|---------------------|----------------|----------------|
| BB-01 | Start application | Run `Main` | App starts, prints number of accounts, shows counter menu without crashing. | Works |
| BB-02 | Show all accounts | In main menu: input `a` | List of accounts printed (Nr., last name, currency). | Works |
| BB-03 | Select existing account | In main menu: input `1` | Account details printed (ID, name, balance, currency) and edit menu shown. | Works |
| BB-04 | Select non-existing account | In main menu: input `99` | Message: account not available (`AccountExeption`) and user stays in menu. | Works |
| BB-05 | Invalid input in main menu | In main menu: input `hello` / `-1` / `!` | Error message about invalid input, menu continues. | Works |
| BB-06 | Deposit valid amount | Select acc 1 → action `e` → amount `100` | Balance increases by 100 and new balance is printed. | Works |
| BB-07 | Deposit invalid amount | Select acc 1 → `e` → amount `abc` | Error message, user is asked again, balance unchanged. | Works |
| BB-08 | Withdraw valid amount | Select acc 1 → `a` → amount `200` | Withdrawal succeeds, balance decreases by 200. | Works |
| BB-09 | Withdraw too much | Select acc 1 → `a` → amount `999999` | Error: insufficient funds, balance unchanged. | Works |
| BB-10 | Transfer same currency | From acc 2 (EUR) → action `ü` → choose acc 4 (EUR) → amount `50` | Sender decreases by 50 EUR, receiver increases by 50 EUR. | Works |
| BB-11 | Transfer different currency (conversion) | From acc 2 (EUR) → `ü` → choose acc 1 (USD) → amount `10` | Transfer completes; receiver gets converted amount (program uses `convertCurrency` rules or API exchange rate if used). | Works |
| BB-12 | Transfer to same account | From acc 1 → `ü` → choose acc 1 | Error message: must choose another account; transfer not executed. | Works |
| BB-13 | Delete account with confirmation | Select acc 4 → action `l` → confirm `j` | Account is removed; selecting it later results in “not available”. | Works |
| BB-14 | Delete account cancel | Select acc 4 → `l` → confirm `n` | Deletion aborted; account still exists. | Works |
| BB-15 | Exchange rate query valid input | In main menu: input `w` → enter `CHF USD` | Either prints `1 CHF = ... USD` OR prints error if API fails (but program must not crash). | Works |
| BB-16 | Exchange rate query invalid input | In main menu: `w` → enter `ABC CHF` | Error message for invalid/unknown currency, prompt again. | Works |
| BB-17 | Quit app | In main menu: input `q` OR in edit menu `q` | Program prints goodbye and exits cleanly. | Works |

-White-box tests:

| ID | Class | Method | Test scenario | Code path / branch tested | Expected behavior |
|----|-------|--------|---------------|---------------------------|-------------------|
| WB-01 | Account | withdraw(double) | Withdraw amount smaller than balance | `else` branch | Returns `true`, balance is reduced |
| WB-02 | Account | withdraw(double) | Withdraw amount equal to balance | `else` branch | Returns `true`, balance becomes `0` |
| WB-03 | Account | withdraw(double) | Withdraw amount greater than balance | `if (amount > balance)` | Returns `false`, balance unchanged |
| WB-04 | Account | deposit(double) | Deposit positive amount | Normal execution | Balance increases correctly |
| WB-05 | Account | deposit(double) | Deposit zero | Edge case | Balance remains unchanged |
| WB-06 | Account | deposit(double) | Deposit negative amount | Missing validation | Balance decreases (logic flaw) |
| WB-07 | Bank | getAccount(int) | Request existing account ID | `return a` inside loop | Correct account returned |
| WB-08 | Bank | getAccount(int) | Request non-existing account ID | Loop ends → `return null` | Returns `null` |
| WB-09 | Counter | transferAmount(Account, Account) | Transfer with insufficient funds | `withdraw()` returns `false` | Exception shown, no transfer |
| WB-10 | Counter | transferAmount(Account, Account) | Transfer with same currency | Conversion skipped | Amount transferred directly |
| WB-11 | Counter | transferAmount(Account, Account) | Transfer with different currency | `convertCurrency()` called | Converted amount deposited |
| WB-12 | Counter | convertCurrency(double, Currency, Currency) | USD → CHF | First `if` branch | Amount multiplied by USD→CHF ratio |
| WB-13 | Counter | convertCurrency(double, Currency, Currency) | USD → EUR | Second `if` branch | Amount multiplied by USD→EUR ratio |
| WB-14 | Counter | convertCurrency(double, Currency, Currency) | CHF → USD | Third `if` branch | Amount multiplied by CHF→USD ratio |
| WB-15 | Counter | convertCurrency(double, Currency, Currency) | Unsupported conversion (e.g. EUR → CHF) | Default branch | Amount returned unchanged |
| WB-16 | ExchangeRateOkhttp | getExchangeRate(String, String) | Successful API call | `try` block | Exchange rate returned |
| WB-17 | ExchangeRateOkhttp | getExchangeRate(String, String) | API error / network failure | `catch` block | Returns `0.0`, error message printed |


-Improvements
#### Validation for money amounts
Currently deposits and withdrawals allow negative values.
  - `deposit(-100)` decreases balance (should be rejected).
  - `withdraw(-100)` increases balance (because subtracting a negative adds money).
#### Money type
- Money is stored as `double`, which can cause rounding issues.
#### Currency conversion
- `convertCurrency` uses fixed hard-coded ratios and is incomplete (EUR->CHF etc. missing).
#### Exception typo
- `AccountExeption` is misspelled.
#### Menu design
- I would redesign the menu since it isn't that userfriendly i didn't knew i needed to put the number of the account to open it till i messed around a bit

