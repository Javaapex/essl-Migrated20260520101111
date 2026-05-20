package com.example.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Objects;

public class AttendanceRecord {
    private String userId;
    private String userName;
    private LocalDate date;

    // Renamed

    private LocalDateTime inTime;
    private LocalDateTime outTime;

    // Duration as text like "6h 4m"
    private String duration;

    public String getUserId() { return userId; }
    public void setUserId(String userId) {
        Objects.requireNonNull(userId, "userId cannot be null"); this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) {
        Objects.requireNonNull(userName, "userName cannot be null"); this.userName = userName; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) {
        Objects.requireNonNull(date, "date cannot be null"); this.date = date; }

    public LocalDateTime getInTime() { return inTime; }
    public void setInTime(LocalDateTime inTime) {
        Objects.requireNonNull(inTime, "inTime cannot be null");
        this.inTime = inTime;
        updateDuration();
    }

    public LocalDateTime getOutTime() { return outTime; }
    public void setOutTime(LocalDateTime outTime) {
        Objects.requireNonNull(outTime, "outTime cannot be null");
        this.outTime = outTime;
        updateDuration();
    }

    public String getDuration() { return duration; }

    // Auto-calculate "6h 4m"
    private void updateDuration() {
        if (inTime != null && outTime != null) {
            Duration d = Duration.between(inTime, outTime);

            long hours = d.toHours();
            long minutes = d.toMinutesPart();

            this.duration = hours + "h " + minutes + "m";
        }
    }
}
