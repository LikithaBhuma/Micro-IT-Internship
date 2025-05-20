1.Project Description:Currency Converter

A currency converter is an application that allows users to convert amounts between different currencies
using real-time exchange rates. It typically features a user-friendly interface where users can select
currencies and input amounts for conversion.
This is a simple Java Swing application that allows users to convert currency amounts from one currency to another using real-time exchange rates from the ExchangeRate-API.
Project Structure:
Project/
└── src/
    └── Project/
        └── CurrencyConverter.java
Features:
-Convert any currency amount between supported international currencies.
-Uses real-time exchange rates via ExchangeRate-API.
-Simple and intuitive GUI built with Java Swing.
-Includes a scrollable table of popular currency codes and names for reference.
-ExchangeRate-API for live currency rates
-org.json for JSON parsing
-Get a free API key from ExchangeRate-API.
ExchangeAPI:
link-https://www.exchangerate-api.com/
JSON-FILE:
link-https://mvnrepository.com/artifact/org.json/json
-add the json .jar file to the project.
-You need an internet connection to fetch live rates.
-Make sure the currency codes are valid (e.g., USD, EUR, INR, etc.).
-The API allows a limited number of requests for free users.



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
![image](https://github.com/user-attachments/assets/0f1d306c-213f-4124-920e-fd444a66198c)
