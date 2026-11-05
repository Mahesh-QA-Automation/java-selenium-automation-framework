# Clean-Room QA Automation Portfolio

An independently written Java Selenium automation portfolio. This project is created from scratch and does not contain or derive from employer-owned source code, internal applications, proprietary test data, credentials, or binaries.

## Stack
- Java 8 source compatibility
- Selenium WebDriver 4.13
- Maven
- TestNG
- Cucumber BDD
- Page Object Model
- Explicit waits
- WebDriver lifecycle hooks
- Failure screenshot attachment

## Application under test
Public SauceDemo sample application: https://www.saucedemo.com/

Demo username: `standard_user`  
Demo password: `secret_sauce`

These are public demo credentials for the sample application, not company credentials.

## Test scope
This repository intentionally contains exactly one BDD scenario:
1. Open SauceDemo login page.
2. Sign in with the public demo account.
3. Verify that the Products page is displayed.

There is one feature file, one step-definition class and one Cucumber/TestNG runner.

## Structure
```text
src/main/java
  config/
  driver/
  pages/
src/test/java
  hooks/
  runner/
  stepdefinitions/
src/test/resources
  features/
pom.xml
testng.xml
README.md
.gitignore
```

## Import into Eclipse
1. Extract the ZIP to a personal workspace folder.
2. Eclipse: File → Import → Maven → Existing Maven Projects.
3. Select this folder and its `pom.xml`.
4. Finish, then right-click project → Maven → Update Project.
5. Ensure Eclipse is configured with a JDK.

## Run
```bash
mvn clean test
```

Use Firefox (Firefox installed):
```bash
mvn clean test -Dbrowser=firefox
```

Cucumber reports are written to `target/cucumber-reports/`. Failed scenarios attach a screenshot to the Cucumber report.

## Configuration
Defaults are in `ConfigReader`. Override with JVM properties, e.g.:
```bash
mvn clean test -Dbrowser=chrome -Dbase.url=https://www.saucedemo.com/
```

## Publishing safety
Only publish this independent portfolio project and work you own. Never add employer code, internal URLs, screenshots, logs, customer data, API keys, access tokens, passwords, proprietary JARs or confidential test data.

## Author
Mahesh V | QA Automation Engineer | SDET
