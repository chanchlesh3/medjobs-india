package com.medjobs.controller;

import com.medjobs.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.medjobs.service.ApplicationService;
import com.medjobs.entity.User;
import com.medjobs.entity.Job;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController{
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/apply")
    public Application apply(@RequestBody Application application){
        return applicationService.applyForJob(application);
    }

    @GetMapping("/myApplications/{seekerId}")
    public List<Application> getMyApplications(@PathVariable Long seekerId) {
        User seeker = new User();
        seeker.setId(seekerId);
        return applicationService.getApplicationsBySeeker(seeker);
    }

    @GetMapping("/jobApplications/{jobId}")
    public List<Application> getJobApplications(@PathVariable Long jobId) {
        Job job = new Job();
        job.setId(jobId);
        return applicationService.getApplicationsByJob(job);
    }



}
