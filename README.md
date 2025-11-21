# Selenium Java Automation Framework

This is a complete Selenium WebDriver automation framework built using **Java**, **TestNG**, and **Page Object Model (POM)**.

## 📌 Features
- Page Object Model (POM)
- TestNG test structure
- Thread-safe WebDriver using ThreadLocal
- Cross-browser execution (Chrome, Firefox)
- Screenshots on failure
- RetryAnalyzer for flaky tests
- Config-driven framework
- Utils for waits, screenshots, config, common actions
- Parallel execution support
- TestNG listeners

## 📁 Project Structure
```
selenium-java-project
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   ├── pages
│   │   │   └── utils
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       └── java
│           └── tests
│
├── pom.xml
└── testng.xml
```

## 🚀 How to Run
```
mvn clean test
```

## 📷 Screenshots on Failure
Screenshots are saved automatically inside `/screenshots`.

## 🔧 Technologies Used
- Java 17+
- Selenium WebDriver
- TestNG
- Maven
- ThreadLocal WebDriver
- POM Architecture
