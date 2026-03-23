# Sauce Demo Test Automation Framework

A Selenium-based test automation framework built with TestNG, Java, and Maven. Includes data-driven testing, parallel execution, and CI/CD integration via GitHub Actions.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 25 | Programming language |
| Selenium 4 | UI test automation |
| TestNG | Test framework |
| Maven | Build & dependency management |
| WebDriverManager | Automatic driver management |
| ExtentReports | HTML test reporting |
| Log4j | Logging |
| GitHub Actions | CI/CD pipeline |

---

## Project Structure

```
src/test/java/
├── base/
│   └── BaseTest.java           # Browser setup & teardown
├── drivers/
│   └── DriverFactory.java      # ThreadLocal WebDriver (parallel-safe)
├── pages/                      # Page Object Model classes
├── tests/                      # Test classes (TC001 - TC011)
└── utilities/
    ├── ConfigReader.java        # Reads config.properties
    ├── DataProviders.java       # TestNG DataProviders
    ├── ExtentManager.java       # ExtentReports setup
    ├── Log.java                 # Log4j wrapper
    ├── ScreenshotUtils.java     # Screenshot on failure
    └── TestListener.java        # TestNG listener
```

---

## Features

- **Page Object Model** — clean separation of test logic and UI interactions
- **Data-Driven Testing** — TestNG DataProvider for login scenarios
- **Parallel Execution** — thread-safe `ThreadLocal<WebDriver>` with configurable thread count
- **Multi-Browser Support** — Chrome, Firefox, Edge
- **Headless Mode** — enabled automatically in CI via `-Dremote=true`
- **ExtentReports** — detailed HTML reports with screenshots on failure
- **Log4j Logging** — console and file logging
- **GitHub Actions** — runs regression and parallel suites on every push

---

## Test Suites

| Suite | File | Description |
|-------|------|-------------|
| Regression | `regression_test.xml` | All tests, single thread |
| Parallel | `parallel_test.xml` | Tests grouped, thread-count: 3 |

---

## Setup & Installation

**Prerequisites:**
- Java 25
- Maven
- Git

**Clone the repository:**
```bash
git clone https://github.com/alkanf/selenium-testng-framework-with-ci-cd
cd selenium-testng-framework-with-ci-cd
```

**Install dependencies:**
```bash
mvn install -DskipTests
```

---

## Running Tests

**Regression suite:**
```bash
mvn test -DsuiteXmlFile=regression_test.xml
```

**Parallel suite:**
```bash
mvn test -DsuiteXmlFile=parallel_test.xml
```

**Headless mode (CI):**
```bash
mvn test -Dremote=true -DsuiteXmlFile=regression_test.xml
```

---

## CI/CD

GitHub Actions automatically runs both suites on every push or pull request to `main`.

Reports and logs are uploaded as artifacts and can be downloaded from the **Actions** tab after each run.

---

## Test Coverage

| # | Test Case | Description |
|---|-----------|-------------|
| TC001 | Login | Valid user login |
| TC002 | Logout | User logout |
| TC003 | Invalid Login | Error message validation |
| TC004 | Product Sort | High-to-low & low-to-high sorting |
| TC005 | Add to Cart | Add product, verify cart count |
| TC006 | Remove from Cart | Remove from cart & inventory page |
| TC007 | Checkout | Complete checkout flow |
| TC008 | Product Detail | Product name & price validation |
| TC009 | Social Media Links | Facebook & X link verification |
| TC010 | End-to-End | Full user journey test |
| TC011 | Data-Driven Login | Valid & invalid login with DataProvider |

---

## Reports

After test execution, reports are generated in:
- `reports/ExtentReport.html` — HTML test report
- `logs/framework.log` — execution log
