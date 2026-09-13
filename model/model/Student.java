package com.academic.tracker.model;

public class Student {
    private String id;
    private String name;
    private double attendancePercentage;
    private double studyHoursPerWeek;
    private double currentMarks;
    private double predictedMarks;
    private RiskLevel riskLevel;

    public Student(String id, String name, double attendancePercentage, double studyHoursPerWeek, double currentMarks) {
        this.id = id;
        this.name = name;
        this.attendancePercentage = attendancePercentage;
        this.studyHoursPerWeek = studyHoursPerWeek;
        this.currentMarks = currentMarks;
        this.riskLevel = RiskLevel.LOW_RISK;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getAttendancePercentage() { return attendancePercentage; }
    public double getStudyHoursPerWeek() { return studyHoursPerWeek; }
    public double getCurrentMarks() { return currentMarks; }
    public double getPredictedMarks() { return predictedMarks; }
    public void setPredictedMarks(double predictedMarks) { this.predictedMarks = predictedMarks; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }

    @Override
    public String toString() {
        return String.format("%s | %-15s | Attn: %5.1f%% | Hours: %4.1f | Marks: %5.1f | Pred: %5.1f | Status: %s",
                id, name, attendancePercentage, studyHoursPerWeek, currentMarks, predictedMarks, riskLevel);
    }
}
