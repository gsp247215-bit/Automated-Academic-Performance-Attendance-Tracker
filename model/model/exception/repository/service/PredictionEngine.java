package com.academic.tracker.service;

import com.academic.tracker.model.Student;
import java.util.List;

public class PredictionEngine {

    // Simple Linear Regression: y = alpha + beta * x
    // x = study hours, y = current marks
    public void trainAndPredict(List<Student> students) {
        if (students.isEmpty()) return;

        double sumX = 0, sumY = 0;
        int n = students.size();

        for (Student s : students) {
            sumX += s.getStudyHoursPerWeek();
            sumY += s.getCurrentMarks();
        }

        double meanX = sumX / n;
        double meanY = sumY / n;

        double numerator = 0, denominator = 0;
        for (Student s : students) {
            double xDiff = s.getStudyHoursPerWeek() - meanX;
            numerator += xDiff * (s.getCurrentMarks() - meanY);
            denominator += xDiff * xDiff;
        }

        double beta = (denominator != 0) ? numerator / denominator : 0;
        double alpha = meanY - (beta * meanX);

        // Apply predictions
        for (Student s : students) {
            double predicted = alpha + (beta * s.getStudyHoursPerWeek());
            // Bound prediction within 0 - 100
            predicted = Math.max(0, Math.min(100, predicted));
            s.setPredictedMarks(predicted);
        }
    }
}
