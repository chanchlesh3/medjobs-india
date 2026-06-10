package com.medjobs.controller;

import com.medjobs.entity.Job;
import com.medjobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/post")
    public Job postJob(@RequestBody Job job) {
        return jobService.postJob(job);
    }

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/location/{location}")
    public List<Job> getJobsByLocation(@PathVariable String location) {
        return jobService.getJobsByLocation(location);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Job> getJobsBySpecialization(@PathVariable String specialization) {
        return jobService.getJobsBySpecialization(specialization);
    }
}
