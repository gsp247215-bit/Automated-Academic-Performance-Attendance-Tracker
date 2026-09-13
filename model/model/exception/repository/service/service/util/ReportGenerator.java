package com.academic.tracker.util;

import com.academic.tracker.model.RiskLevel;
import com.academic.tracker.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public static void printConsoleReport(List<Student> students, Map<RiskLevel, List<Student>> categorized) {
        System.out.println("\n=========================================================================================");
        System.out.println("                         ACADEMIC PERFORMANCE & RISK REPORT                              ");
        System.out.println("=========================================================================================");
        students.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("SUMMARY STATS:");
        System.out.printf("Total Students Analyzed : %d%n", students.size());
        System.out.printf("Critical Risk          : %d%n", categorized.get(RiskLevel.CRITICAL_RISK).size());
        System.out.printf("Medium Risk            : %d%n", categorized.get(RiskLevel.MEDIUM_RISK).size());
        System.out.printf("Low Risk               : %d%n", categorized.get(RiskLevel.LOW_RISK).size());
        System.out.println("=========================================================================================\n");
    }

    public static void exportSummaryCSV(String outputPath, List<Student> students) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writer.println("StudentID,Name,Attendance,StudyHours,CurrentMarks,PredictedMarks,RiskLevel");
            for (Student s : students) {
                writer.printf("%s,%s,%.2f,%.2f,%.2f,%.2f,%s%n",
                        s.getId(), s.getName(), s.getAttendancePercentage(),
                        s.getStudyHoursPerWeek(), s.getCurrentMarks(),
                        s.getPredictedMarks(), s.getRiskLevel().name());
            }
        }
    }
}
