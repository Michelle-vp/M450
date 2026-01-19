# Task 3 – Banking Simulation Documentation

## Project Overview

This project simulates a simple banking system using a console application.  
Users can manage multiple bank accounts, perform transactions, and check currency exchange rates.

The system consists of the following main classes:

- `Bank`
- `Account`
- `Counter`
- `ExchangeRateOkhttp`
- `Main`
- `Currency` (enum)

---

## System Structure

### Bank
The `Bank` class manages all accounts using an `ArrayList<Account>`.  
It provides functionality to:

- Create accounts
- Delete accounts
- Retrieve accounts by ID
- Print account details
- Print lists of accounts
- Handle transfers between accounts (via `Counter`)

---

### Account
Represents a bank account.

Attributes:
- `id`
- `userLastName`
- `currency`
- `balance`

Main functions:
- Deposit money
- Withdraw money (with balance check)
- Print balance
- Getters for account information

---

### Counter
Acts as the user interface (console menu).

Responsibilities:
- Allow the user to select accounts
- Perform deposits and withdrawals
- Transfer money between accounts
- Delete accounts
- Validate user input
- Convert currencies (internally or via API)

The class controls all interactions between the user and the bank.

---

### ExchangeRateOkhttp
Responsible for retrieving live currency exchange rates using:

- OkHttp (HTTP client)
- GSON (JSON parsing)

It calls an external API and returns the conversion rate between two currencies.

---

### Main
Starts the program and initializes several accounts.  
It repeatedly allows the user to select and edit accounts through the `Counter`.

---

## Key Concepts

### Multi-account Management
The bank stores accounts in a dynamic list, allowing:

- Creation of unlimited accounts
- Access by unique ID
- Transfers between accounts

---

### Input Validation
The system validates:
- Menu commands (regex)
- Numeric inputs
- Currency codes
- Balance limits

---

### Currency Handling
- Accounts store their own currency type.
- Transfers between accounts trigger currency conversion when needed.
- Exchange rates can be retrieved from an API.

---

### Error Handling
- Invalid input is caught using exceptions.
- Withdrawals with insufficient funds are prevented.
- API errors return safe default values.

---

## Weaknesses / Limitations

- Money stored as `double` (rounding risk)
- Limited currency conversion rules internally
- Hard-coded API key
- Business logic mixed with UI in `Counter`

---

## Conclusion

The banking simulation demonstrates:

- Object-oriented design
- Separation between account management and user interaction
- Basic financial transaction handling
- Integration of an external API
- Validation and error handling

It is a functional prototype of a small banking system.
