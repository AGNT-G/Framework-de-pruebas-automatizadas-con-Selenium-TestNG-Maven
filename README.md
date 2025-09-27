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
   https://github.com/AGNT-G/Framework-de-pruebas-automatizadas-con-Selenium-TestNG-Maven.git
## Import the project into IntelliJ IDEA (or your preferred IDE).

## Run the tests using:
1. Open IntelliJ IDEA.  
2. On the right side panel, locate the **Maven** tab.  
3. Navigate to:  Lifecycle > test
4. Double-click `test` to run all tests.

## Run a Specific Test Class
```bash
mvn -Dtest=LoginTest test
```
## Troubleshooting

Page Loads Too Slow
The demo website may respond very slowly. If the site doesn’t load, tests may fail due to timeout errors.
✔️ Solution: Retry later or increase the WebDriverWait timeout.

Maven Not Found
Make sure Maven is installed and added to the system PATH.
Check with:
```bash
mvn -v
```

## Dependencies Not Downloaded
In IntelliJ, go to the Maven tab → Click Reload All Maven Projects.


## Notes

Make sure you have Java 17 and Maven installed.

Update the testng.xml file if you want to include/exclude specific test suites.

Excel files used for data-driven testing are located in src/test/resources.

The execution speed depends on the demo website’s availability.

Tests may fail if the website is down or unresponsive.

For consistency, it is recommended to use Google Chrome as the browser.
