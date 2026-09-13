package com.academic.tracker.service;

import com.academic.tracker.model.RiskLevel;
import com.academic.tracker.model.Student;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class RiskAssessmentService {

    public void evaluateRisk(List<Student> students) {
        for (Student student : students) {
            double attendance = student.getAttendancePercentage();
            double predictedMarks = student.getPredictedMarks();

            if (attendance < 65.0 || predictedMarks < 40.0) {
                student.setRiskLevel(RiskLevel.CRITICAL_RISK);
            } else if (attendance < 75.0 || predictedMarks < 60.0) {
                student.setRiskLevel(RiskLevel.MEDIUM_RISK);
            } else {
                student.setRiskLevel(RiskLevel.LOW_RISK);
            }
        }
    }

    public Map<RiskLevel, List<Student>> categorizeByRisk(List<Student> students) {
        Map<RiskLevel, List<Student>> map = new EnumMap<>(RiskLevel.class);
        for (RiskLevel level : RiskLevel.values()) {
            map.put(level, new ArrayList<>());
        }
        for (Student s : students) {
            map.get(s.getRiskLevel()).add(s);
        }
        return map;
    }
}
