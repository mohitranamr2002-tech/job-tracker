package com.jobtracker.job_tracker.controller;


import com.jobtracker.job_tracker.dto.ApplicationResponse;
import com.jobtracker.job_tracker.dto.CreateApplicationRequest;
import com.jobtracker.job_tracker.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponse create(@Valid @RequestBody CreateApplicationRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ApplicationResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ApplicationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }
}