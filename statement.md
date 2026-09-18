### **5.2 `statement.md`**

```markdown
# Project Statement

## 1. Problem Statement
In higher education institutions, tracking student attendance, study habits, and assignment grades is frequently managed through disparate manual logs. This makes it difficult for academic advisors and instructors to spot students facing academic failure early in the semester. Without early automated warning systems, interventions often occur too late—after midterms or final exams—resulting in higher dropout rates and preventable course failures.

---

## 2. Project Scope
The **Automated Academic Performance & Attendance Tracker** is a modular Java desktop application designed to streamline student performance tracking. 

### In-Scope:
- Parsing and validating raw student performance logs from CSV files.
- Implementing native statistical modeling (Simple Linear Regression) to predict student assessment outcomes based on study habits.
- Categorizing students into structured risk tiers (`LOW_RISK`, `MEDIUM_RISK`, `CRITICAL_RISK`).
- Generating formatted console dashboards and exportable summary CSV files for course instructors.

### Out-of-Scope (Future Enhancements):
- Multi-user authentication and role-based web dashboards (GUI).
- Database migrations (SQL/NoSQL) and real-time LMS (e.g., Canvas, Moodle) API integrations.

---

## 3. Target Users
1. **Course Instructors / Professors:** Need automated summaries to identify which students require immediate academic intervention or counseling.
2. **Academic Advisors & Department Heads:** Require exportable risk data to track student retention metrics across academic cohorts.
3. **Teaching Assistants (TAs):** Need automated verification of student attendance thresholds and assignment grade trends.

---

## 4. High-Level System Features
- **CSV Ingestion & Validation Engine:** Traps corrupt fields (e.g., negative marks, non-numeric strings) without breaking program execution.
- **Predictive Analytics Module:** Calculates mathematical regression slopes and intercepts to estimate final grade trends.
- **Threshold-Based Risk Engine:** Applies multi-condition checks (combining attendance percentages and predicted scores) to flag vulnerable students.
- **Automated Summary Reporting:** Exports structured analytics to CSV files for administrative archiving and immediate review.
