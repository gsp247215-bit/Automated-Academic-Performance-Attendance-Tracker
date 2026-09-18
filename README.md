# Automated Academic Performance & Attendance Tracker

An automated Java application that processes student attendance, study hours, and assessment data to identify early academic risk factors and predict final grades using statistical regression modeling.

---

## Overview

Manual tracking of attendance and internal assessment marks often leads to delayed interventions for failing students. This lightweight Java project parses student records from CSV files, calculates academic risk categories (`LOW_RISK`, `MEDIUM_RISK`, `CRITICAL_RISK`), applies a mathematical Simple Linear Regression model to forecast performance, and exports summary reports for faculty action.

---

## Key Features

- **Automated CSV Data Ingestion:** Reads student data logs and validates numeric ranges while gracefully skipping corrupt entries.
- **Native Linear Regression Engine:** Predicts final student marks ($y = \alpha + \beta x$) using study hours as a key predictor variable—built from scratch in Java without heavy external dependencies.
- **Categorical Risk Classification:** Automatically flags students falling below attendance (<75%) or predicted grade thresholds (<60 marks).
- **Dual Reporting System:** Outputs formatted real-time console summaries and generates an exportable `academic_risk_report.csv` file.
- **Unit Tested:** Includes comprehensive JUnit 5 test coverage validating regression math, score bounding, and error handling.

---

## Technologies & Tools Used

- **Language:** Java 17+
- **Build Tool:** Apache Maven
- **Testing Framework:** JUnit 5
- **Version Control:** Git & GitHub
- **Storage Format:** Flat-file CSV

---

## Project Directory Structure

```text
student-tracker/
├── README.md
├── statement.md
├── pom.xml
├── students.csv                     # Sample input data file
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── academic/
    │               └── tracker/
    │                   ├── Main.java                      # Application Entry Point
    │                   ├── model/
    │                   │   ├── Student.java               # Student Entity Model
    │                   │   └── RiskLevel.java             # Risk Category Enum
    │                   ├── repository/
    │                   │   └── StudentRepository.java     # CSV I/O & Input Validation
    │                   ├── service/
    │                   │   ├── RiskAssessmentService.java # Categorization Engine
    │                   │   └── PredictionEngine.java      # Linear Regression Logic
    │                   ├── exception/
    │                   │   └── InvalidDataException.java  # Custom Error Exception
    │                   └── util/
    │                       └── ReportGenerator.java       # Console & File Export Output
    └── test/
        └── java/
            └── com/
Installation & Setup Instructions
Prerequisites
Java Development Kit (JDK 17 or higher)

Apache Maven 3.8+

Git

Installation
Clone the repository:
git clone [https://github.com/your-username/student-tracker.git](https://github.com/your-username/student-tracker.git)
cd student-tracker
                └── academic/
                    └── tracker/
                        └── PredictionEngineTest.java      # Unit Tests
Compile and build the project using Maven:
mvn clean package
Running the Application
Execute the application using Java:
java -cp target/student-tracker-1.0-SNAPSHOT.jar com.academic.tracker.Main
Expected Output Example
=========================================================================================
                         ACADEMIC PERFORMANCE & RISK REPORT                              
=========================================================================================
S101 | John Doe        | Attn:  85.0% | Hours: 12.5 | Marks:  78.0 | Pred:  81.3 | Status: LOW_RISK
S102 | Jane Smith      | Attn:  60.0% | Hours:  4.0 | Marks:  45.0 | Pred:  42.1 | Status: CRITICAL_RISK
-----------------------------------------------------------------------------------------
SUMMARY STATS:
Total Students Analyzed : 2
Critical Risk          : 1
Medium Risk            : 0
Low Risk               : 1
=========================================================================================
Report exported successfully to: academic_risk_report.csv
