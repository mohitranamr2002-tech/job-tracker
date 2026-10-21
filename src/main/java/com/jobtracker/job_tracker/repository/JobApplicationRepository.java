package com.jobtracker.job_tracker.repository;


import com.jobtracker.job_tracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}