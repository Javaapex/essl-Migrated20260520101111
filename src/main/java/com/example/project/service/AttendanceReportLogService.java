package com.example.project.service;

import com.example.project.model.AttendanceReportLog;
import com.example.project.repository.AttendanceReportLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AttendanceReportLogService {
    private final AttendanceReportLogRepository repository;

    public AttendanceReportLogService(AttendanceReportLogRepository repository) {
        this.repository = repository;
    }

    public AttendanceReportLog save(AttendanceReportLog log) {
        Objects.requireNonNull(log, "log cannot be null");
        return repository.save(log);
    }

    public List<AttendanceReportLog> findAll() {
        return repository.findAll();
    }
}

