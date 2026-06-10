package com.medjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medjobs.entity.Application;
import org.springframework.stereotype.Repository;
import com.medjobs.entity.Job;
import com.medjobs.entity.User;


import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
    List<Application> findByAppliedBy(User appliedBy);
    List<Application> findByJob(Job job);
    List<Application> findByStatus(String status);
}
