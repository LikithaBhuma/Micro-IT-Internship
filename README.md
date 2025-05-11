1.Project Description:Calculator

A simple calculator is a basic application that performs fundamental arithmetic operations such as
addition, subtraction, multiplication, and division. It typically features a user-friendly interface where users
can input numbers and select operations, displaying the results in real-time.
This is a simple calculator application built using Java Swing in Eclipse IDE. It performs basic arithmetic operations like addition, subtraction, multiplication, and division with a clean and colorful GUI.
Project Structure:
Project/
└── src/
    └── Project/
        └── Calculator.java
Features:
-Simple and clean GUI using Java Swing.
-Handles basic operations: +, -, *, /.
-Error handling for:Division by zero.
-Invalid inputs.
-Clear button (C) to reset the input.
-Displays result in real-time using a text field.
-GUI designed with JFrame, JTextField, JPanel, and JButtons.
-Layout managed using BorderLayout and GridLayout.
-Input is restricted to digits and operators through button clicks.


2.Project Description:Password Generator

A password generator is a tool that creates strong, random passwords to enhance security. Users can
specify criteria such as password length and the inclusion of uppercase letters, lowercase letters,
numbers, and special characters. The generated passwords are typically complex and difficult to guess,
helping to protect user accounts and sensitive information.
This project is a Password Generator application developed using Java Swing in Eclipse IDE. It allows users to generate strong and secure passwords by selecting desired character sets and specifying password length.
Project Structure:
PasswordGeneratorProject/
└── src/
    └── Project/
        └── PasswordGenerator.java
Features:
-Generates a random password based on:
  -Uppercase letters (A-Z)
  -Lowercase letters (a-z)
  -Numbers (0-9)
  -Special characters (!@#$%^&* etc.)
-Allows users to:
  -Enter desired password length
  -Select which character sets to include
  -Displays the password in a text area
-Input validation for:
  -Missing character set selections
  -Invalid or empty length fields
---UI Components Used
JFrame – Main window
JPanel – Layout containers
JTextField – For inputting password length
JCheckBox – For selecting character types
JTextArea – For showing the generated password
JButton – Trigger password generation
GridLayout and BorderLayout – For organizing layout
-UI is created and updated using the Event Dispatch Thread (SwingUtilities.invokeLater)
-Random password generation uses java.util.Random
