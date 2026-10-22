package com.jobtracker.job_tracker.service;


import com.jobtracker.job_tracker.dto.ApplicationResponse;
import com.jobtracker.job_tracker.dto.CreateApplicationRequest;
import com.jobtracker.job_tracker.dto.StatusUpdateRequest;
import com.jobtracker.job_tracker.dto.UpdateApplicationRequest;
import com.jobtracker.job_tracker.entity.JobApplication;
import com.jobtracker.job_tracker.exeption.ResourceNotFoundException;
import com.jobtracker.job_tracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public ApplicationResponse create(CreateApplicationRequest request) {
        JobApplication app = new JobApplication();
        app.setCompany(request.company().trim());
        app.setRoleTitle(request.roleTitle().trim());
        app.setLocation(request.location());
        app.setJobUrl(request.jobUrl());
        app.setStatus(request.status());
        app.setAppliedDate(request.appliedDate());
        app.setNotes(request.notes());

        JobApplication saved = repository.save(app);
        return ApplicationResponse.from(saved);
    }

    public List<ApplicationResponse> getAll() {
        return repository.findAll().stream()
                .map(ApplicationResponse::from)
                .toList();
    }

    public ApplicationResponse getById(Long id) {
        return ApplicationResponse.from(findOrThrow(id));
    }

    public ApplicationResponse update(Long id, UpdateApplicationRequest request) {
        JobApplication app = findOrThrow(id);
        app.setCompany(request.company().trim());
        app.setRoleTitle(request.roleTitle().trim());
        app.setLocation(request.location());
        app.setJobUrl(request.jobUrl());
        app.setStatus(request.status());
        app.setAppliedDate(request.appliedDate());
        app.setNotes(request.notes());
        return ApplicationResponse.from(repository.save(app));
    }

    public ApplicationResponse updateStatus(Long id, StatusUpdateRequest request) {
        JobApplication app = findOrThrow(id);
        app.setStatus(request.status());
        return ApplicationResponse.from(repository.save(app));
    }

    public void delete(Long id) {
        JobApplication app = findOrThrow(id);
        repository.delete(app);
    }

    private JobApplication findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Application not found with id " + id));
    }
}