package com.academic.tracker.repository;

import com.academic.tracker.exception.InvalidDataException;
import com.academic.tracker.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Student> loadFromCSV(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Data file not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1 && line.toLowerCase().contains("id")) continue; // Skip header

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                try {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double attendance = Double.parseDouble(parts[2].trim());
                    double hours = Double.parseDouble(parts[3].trim());
                    double marks = Double.parseDouble(parts[4].trim());

                    validateStudentData(attendance, hours, marks);
                    students.add(new Student(id, name, attendance, hours, marks));
                } catch (InvalidDataException | NumberFormatException e) {
                    System.err.println("Warning: Skipping malformed data at line " + lineNumber + " -> " + e.getMessage());
                }
            }
        }
        return students;
    }

    private void validateStudentData(double attendance, double hours, double marks) throws InvalidDataException {
        if (attendance < 0 || attendance > 100) {
            throw new InvalidDataException("Attendance must be between 0 and 100.");
        }
        if (hours < 0 || hours > 168) {
            throw new InvalidDataException("Study hours out of realistic range.");
        }
        if (marks < 0 || marks > 100) {
            throw new InvalidDataException("Marks must be between 0 and 100.");
        }
    }
}
