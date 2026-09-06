# Selenium Java Automation Framework

A scalable Selenium WebDriver automation framework built using Java, TestNG, Maven, Page Object Model (POM), Allure Reporting, Git, and Jenkins CI/CD.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Jackson JSON
- Allure Reports
- Git & GitHub
- Jenkins
- Chrome
- Edge
- Firefox

## Key Features

- Page Object Model design
- ThreadLocal WebDriver
- Multi-browser execution
- Headless browser execution
- TestNG DataProvider
- JSON-based test data
- Centralized configuration
- Allure reporting
- Allure test steps
- Failure screenshots
- Jenkins CI execution
- Jenkins parameterized browser selection


## Project Structure

```text
selenium-java-Automation-framework
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       │   └── BasePage.java
│   │       │
│   │       ├── factory
│   │       │   └── DriverFactory.java
│   │       │
│   │       ├── pages
│   │       │   ├── LoginPage.java
│   │       │   ├── ProductsPage.java
│   │       │   ├── CartPage.java
│   │       │   └── CheckoutPage.java
│   │       │
│   │       └── utils
│   │           ├── ConfigReader.java
│   │           └── TestDataReader.java
│   │
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── dataProviders
│       │   │   └── LoginDataProvider.java
│       │   │
│       │   ├── listeners
│       │   │   └── TestListener.java
│       │   │
│       │   └── tests
│       │       ├── LoginTest.java
│       │       ├── LoginDataTest.java
│       │       └── ProductTest.java
│       │
│       └── resources
│           ├── config.properties
│           └── testData
│               └── TestData.json
│
├── testng.xml
├── pom.xml
├── .gitignore
└── README.md




## How to Run Tests

### Run Tests with Default Configuration

```bash
mvn clean test