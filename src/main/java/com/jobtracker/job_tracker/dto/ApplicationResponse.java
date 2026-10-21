package com.jobtracker.job_tracker.dto;



import com.jobtracker.job_tracker.entity.ApplicationStatus;
import com.jobtracker.job_tracker.entity.JobApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApplicationResponse(
        Long id,
        String company,
        String roleTitle,
        String location,
        String jobUrl,
        ApplicationStatus status,
        LocalDate appliedDate,
        String notes,
        LocalDateTime createdAt
) {
    public static ApplicationResponse from(JobApplication app) {
        return new ApplicationResponse(
                app.getId(),
                app.getCompany(),
                app.getRoleTitle(),
                app.getLocation(),
                app.getJobUrl(),
                app.getStatus(),
                app.getAppliedDate(),
                app.getNotes(),
                app.getCreatedAt());
    }
}