package com.example.project.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AttendanceSoapData {

    private String userId;
    private String userName;
    private String timeStamp;
    private String direction;

    public String getUserId() { return userId; }
    public void setUserId(String userId) {
        Objects.requireNonNull(userId, "userId cannot be null"); this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) {
        Objects.requireNonNull(userName, "userName cannot be null"); this.userName = userName; }

    public String getTimeStamp() { return timeStamp; }
    public void setTimeStamp(String timeStamp) {
        Objects.requireNonNull(timeStamp, "timeStamp cannot be null"); this.timeStamp = timeStamp; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) {
        Objects.requireNonNull(direction, "direction cannot be null"); this.direction = direction; }

    /**
     * Converts "2025
     */
    public LocalDateTime getTimeAsDateTime() {
        return LocalDateTime.parse(timeStamp);
    }

    /**
     * Converts "2025-11-25T10:41:50" → "10:41"
     */
    public String getTimeOnly() {
        LocalDateTime dt = LocalDateTime.parse(timeStamp);
        return dt.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public String toString() {
        return userId + " | " + timeStamp + " | " + direction;
    }
}
