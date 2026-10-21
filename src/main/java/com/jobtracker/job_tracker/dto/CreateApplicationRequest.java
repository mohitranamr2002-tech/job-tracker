package com.jobtracker.job_tracker.dto;


import com.jobtracker.job_tracker.entity.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateApplicationRequest(
        @NotBlank(message = "Company is required")
        String company,

        @NotBlank(message = "Role title is required")
        String roleTitle,

        String location,
        String jobUrl,
        ApplicationStatus status,
        LocalDate appliedDate,
        String notes
) {
}