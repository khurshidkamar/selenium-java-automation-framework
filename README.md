# Selenium Java Automation Framework

This is a sample Selenium WebDriver automation framework built using **Java**, **TestNG**, and **Page Object Model (POM)**.
The repository includes a small demo test suite that logs into Sauce Demo and verifies inventory, cart and checkout pages.

## 📌 Features implemented in this project
- Page Object Model (POM)
- TestNG test structure
- Thread-safe WebDriver using ThreadLocal
- Cross-browser execution (Chrome, Firefox)
- Basic Screenshots on failure (utility present)
- RetryAnalyzer (skeleton present)
- Config-driven framework (config.properties)
- Utils for WebDriverFactory and basic waits via BasePage
- Parallel execution support via testng.xml
- Example tests: LoginTest, InventoryTest, CartTest, CheckoutTest

## Demo site
This demo uses the public site: https://www.saucedemo.com
Use credentials in `config.properties` (standard_user / secret_sauce)

## 🚀 How to Run
1. Ensure Java & Maven are installed.
2. From project root:
```
mvn clean test -Dbrowser=chrome
```
