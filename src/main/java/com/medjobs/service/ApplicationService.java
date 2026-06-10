package com.medjobs.service;

import com.medjobs.entity.Application;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.medjobs.repository.ApplicationRepository;
import com.medjobs.entity.Job;
import com.medjobs.entity.User;

import java.util.List;

@Service
public class ApplicationService{
    @Autowired
    ApplicationRepository applicationRepository;

    public Application applyForJob(Application application){
        return applicationRepository.save(application);

    }

    public List<Application> getApplicationsBySeeker(User seeker) {
        return applicationRepository.findByAppliedBy(seeker);
    }

    public List<Application> getApplicationsByJob(Job job) {
        return applicationRepository.findByJob(job);
    }
}
