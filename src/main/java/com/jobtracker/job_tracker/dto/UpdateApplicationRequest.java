package com.jobtracker.job_tracker.dto;


import com.jobtracker.job_tracker.entity.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateApplicationRequest(
        @NotBlank(message = "Company is required")
        String company,

        @NotBlank(message = "Role title is required")
        String roleTitle,

        String location,
        String jobUrl,

        @NotNull(message = "Status is required")
        ApplicationStatus status,

        LocalDate appliedDate,
        String notes
) {
}
