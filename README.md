# UI + API Test Automation Suite


## 📑 Table of Contents
1. [About the Project]
2. [Tech Stack]
3. [Project Structure]
4. [Setup & Prerequisites]
5. [Running the Tests]
6. [Reports]
7. [Extending the Suite]
8. [Author]

---

## About the Project
This repository contains an **end‑to‑end automation framework** that tests both:

| Layer | Stack | Target |
|-------|-------|--------|
| **UI** | Selenium 4 + WebDriverManager | https://automationexercise.com |
| **API** | Rest Assured 5 | • ReqRes sample APIs <br>• GoRest User APIs |

The suite is written in **Java 11** with **TestNG** as the test runner and **ExtentReports 5** for rich HTML reporting.  
It demonstrates:

- Page Object Model (POM) for UI pages  
- Reusable API page classes & POJOs  
- Positive + negative test scenarios  
- Unified Extent report for all layers  

---

## Tech Stack
| Category | Tool / Library | 
|----------|----------------|
| Build    | Maven          | 
| Language | Java           |
| UI       | Selenium       | 
| API      | Rest‑Assured   | 
| Tests    | TestNG         | 
| Reports  | ExtentReports  | 
| Others   | WebDriverManager, 

---

## Project Structure

├── src
│ ├── main
│ │ └── java
│ │ ├── pages/ # UI Page Objects
│ │ ├── com/automation/api/pojo # API request/response POJOs
│ │ └── com/automation/utils # ExtentReportManager, ScreenshotUtil…
│ └── test
│ └── java
│ ├── tests/ # UI test classes
│ └── pages/ # API test classes
├── testng-ui.xml # Runs all UI suites
├── testng-api.xml # Runs all API suites
├── pom.xml
└── reports/ # Extent HTML output


---

## Setup & Prerequisites
# 1. Clone the repo
git clone git@github.com:Kashish-satija29/Regie.ai.git
cd <repo>

# 2. Ensure JDK 11+ & Maven installed
java -version
mvn -v

**You’ll see:**

Separate test groups for UI and API

Step‑level logs, request/response bodies

**Author**
Kashish Satija – Automation Engineer
