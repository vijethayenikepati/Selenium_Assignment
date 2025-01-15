# Vehicle Valuation Test Automation Framework

## Introduction
This is a Selenium-based test automation framework designed to validate vehicle properties fetched from a car valuation website against expected results. It supports multiple input files, parallel execution, and browser configuration via Maven.

## Pre-requisites
1. **Java**: Install Java 8 or higher.
2. **Maven**: Install Apache Maven.
3. **Browser Drivers**: The framework uses **WebDriverManager** to download the required browser drivers automatically.

## How to Run

- **Run Tests Locally**:  
  Run the tests using Maven:  
  ```bash
  mvn clean test
By default, the tests run on Chrome. To run on a different browser, use the -Dbrowser parameter:
  mvn clean test -Dbrowser=firefox
Supported browsers:
  chrome
  firefox
Run Tests in Parallel:
Parallel execution is enabled by default via JUnit 5. It is configured in src/test/resources/junit-platform.properties:

junit.jupiter.execution.parallel.enabled = true
junit.jupiter.execution.parallel.mode.default = concurrent
junit.jupiter.execution.parallel.config.strategy = dynamic

To run tests in parallel, use:
mvn clean test

Run Tests for Multiple Input Files:
The VehicleSearchMultipleFilesTest dynamically processes all input files in the src/test/resources/input_files/ directory.

mvn clean test -Dtest=VehicleSearchMultipleFilesTest

**Logging**
Logs are generated for each test run:
Console logs for immediate feedback.
File logs stored in logs/test-log.log.
**Adding New Input/Output Files**
Add input files to src/test/resources/input_files/ (e.g., car_input_3.txt).
Add corresponding output files to src/test/resources/output_files/ (e.g., car_output_3.txt).
**Debugging and Enhancements**
Use the logs in logs/test-log.log for detailed test execution steps.
Extend the framework by adding new test classes in the tests package.



