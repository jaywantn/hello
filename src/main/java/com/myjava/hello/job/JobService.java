package com.myjava.hello.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    String  createJob(Job job);
    
    Job getJobById(Long id);
    boolean deletJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}  
