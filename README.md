# Selenium Java Automation Framework

A modern, scalable, and parallel‑ready automation framework built using Java 21, Selenium 4, TestNG, Extent Reports, and WebDriverManager. Designed for UI test automation with a clean Page Object Model (POM) architecture and support for Chrome and Edge browsers.

🚀 Features

- Java 21
- Selenium 4
- TestNG
- Parallel execution using ThreadLocal WebDriver
- Modern Page Object Model (POM) using By locators
- Extent Reports for rich HTML reporting
- Chrome & Edge browser support
- Config-driven (`src/main/resources/config.properties`)
- Reusable utilities (WaitUtils, ConfigReader)
- Clean project structure
- Easy to extend for API, mobile, or CI/CD

## Project Structure

Selenium-Java-Framework/
├── src/main/java/
│   ├── base/               # BaseTest with parallel execution + reporting
│   ├── driver/             # DriverFactory (Chrome + Edge)
│   ├── pages/              # Page Objects (modern style)
│   ├── utils/              # WaitUtils, ConfigReader, Logger
│   └── reports/            # ExtentManager
│
├── src/main/resources/
│   ├── config.properties   # Browser + base URL
   └── testdata/           # JSON test data (optional)
│
├── src/test/java/
│   ├── tests/              # TestNG test classes
│   └── testng.xml          # Parallel execution config
│
├── pom.xml
└── README.md

## Tech Stack

- Language: Java 21
- UI Automation: Selenium WebDriver 4
- Test Runner: TestNG
- Reporting: Extent Reports
- Browser Drivers: WebDriverManager
- Build Tool: Maven

## Setup Instructions

1. Install Requirements

- Java 21
- Maven
- VS Code (recommended)
- Java Extension Pack (if using VS Code)
- Chrome or Edge browser

2. Clone the Repository

```powershell
git clone https://github.com/<your-username>/selenium-java-framework.git
cd selenium-java-framework
```

3. Update Configuration

Edit `src/main/resources/config.properties` and set your preferred values. Example:

```properties
browser=chrome
baseUrl=https://the-internet.herokuapp.com
implicitWait=10
explicitWait=15
```

Switch to Edge by changing:

```properties
browser=edge
```

4. Run Tests

Using Maven (from project root):

```powershell
mvn clean test
```

Or run the TestNG suite directly from your IDE by running `testng.xml` (right-click → Run).

## Reports

After execution, Extent Report is generated (example path):

```
test-output/ExtentReport.html
```

Open it in a browser to view test steps, pass/fail status, screenshots on failure (if configured), execution time and parallel logs.

## Included Test Scenarios (examples)

- Login Tests
  - Valid login
  - Invalid login
- Dropdown Tests
  - Select Option 1
- Checkbox Tests
  - Validate checkbox selection

## Future Enhancements

- API automation using Rest Assured
- GitHub Actions CI pipeline
- Dockerized Selenium Grid
- Allure Reports (optional)
- Data-driven testing (JSON/Excel)

## Author

Arunkumaran Pasupathi
Automation Engineer | Java | Selenium | API | CI/CD
GitHub: https://github.com/Saint-1987

---

