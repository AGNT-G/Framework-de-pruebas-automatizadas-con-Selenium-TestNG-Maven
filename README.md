# Selenium Automation Project

This project contains automated tests developed with **Java + Selenium**.  
The goal is to practice building automation frameworks following industry best practices.

## Technologies Used
- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Data-Driven Testing** (Excel)

## Project Structure
- `src/test/java/pages` → Page classes (Page Object Model).
- `src/test/java/tests` → Test cases with TestNG.
- `src/test/java/utils` → Utilities and data handling (Excel).
- `testng.xml` → Configuration file to execute tests.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/AGNT-G/REPO-NAME.git
## Import the project into IntelliJ IDEA (or your preferred IDE).

## Run the tests using:

The TestNG panel in your IDE, or

Command line:
```bash
mvn clean test

## Notes

Make sure you have Java 17 and Maven installed.

Update the testng.xml file if you want to include/exclude specific test suites.

Excel files used for data-driven testing are located in src/test/resources.
