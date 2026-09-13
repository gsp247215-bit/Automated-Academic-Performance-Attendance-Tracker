package com.academic.tracker.model;

public enum RiskLevel {
    LOW_RISK("Green - Good Standing"),
    MEDIUM_RISK("Yellow - Needs Attention"),
    CRITICAL_RISK("Red - Immediate Intervention Required");

    private final String description;

    RiskLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
