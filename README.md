Bank System

A simple banking system developed in Java to practice Object-Oriented Programming (OOP), collections, file handling, and business logic implementation.

Features
Create bank accounts
Deposit money
Withdraw money
Transfer funds between accounts
View account balance
View transaction history
Save data to a file
Load data when the application starts
Technologies
Java 21
Maven
ArrayList Collections
File I/O (BufferedReader, FileReader, PrintWriter)
Object-Oriented Programming
Project Structure
src/
└── main/
    └── java/
        ├── Main.java
        ├── Bank.java
        ├── BankAccount.java
        └── BankStorage.java
Classes
BankAccount

Represents a bank account.

Responsibilities:

Store owner information
Store balance
Deposit funds
Withdraw funds
Maintain transaction history
Bank

Represents the banking system.

Responsibilities:

Store multiple accounts
Find accounts by owner
Perform transfers
Manage account collection
BankStorage

Handles data persistence.

Responsibilities:

Save account information to a file
Load account information from a file
Main

Application entry point.

Responsibilities:

Display menu
Read user input
Execute banking operations
Example Usage
Create an Account
1 - Create Account

Owner name:
Mariana
Deposit Money
2 - Deposit

Owner name:
Mariana

Amount:
100
Transfer Funds
4 - Transfer

From:
Mariana

To:
Joao

Amount:
50
Show Balance
5 - Show Balance

Balance: 50.0
Data Persistence

Account data is stored in:

accounts.txt

Example:

Mariana;100.0
Joao;50.0

The file is automatically loaded when the application starts and saved when the application closes.

Learning Objectives

This project was created to practice:

Classes and Objects
Encapsulation
Constructors
Collections
File Handling
Business Logic
Control Flow
Console Applications
Java Project Organization
Future Improvements
Unique account IDs
Account authentication
Interest calculation
Account removal
Transaction timestamps
JSON persistence
Database integration (MySQL/PostgreSQL)
Spring Boot REST API version
Unit testing with JUnit
Author

Developed as a portfolio project for studying Java and backend development.
