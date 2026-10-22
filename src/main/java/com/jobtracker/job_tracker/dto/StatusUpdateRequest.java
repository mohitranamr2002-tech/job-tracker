package com.jobtracker.job_tracker.dto;


import com.jobtracker.job_tracker.entity.ApplicationStatus;
import jakarta.validation.constraints.NotNull;

public record StatusUpdateRequest(
        @NotNull(message = "Status is required")
        ApplicationStatus status
) {
}