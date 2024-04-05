package com.myjava.hello.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myjava.hello.job.Job;
import com.myjava.hello.job.JobService;

@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll(){
        return jobs;
    }
    
    @Override
    public String createJob(@RequestBody Job job){
        job.setId(nextId++);
        jobs.add(job);
        return "added successfully";
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs ){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deletJobById(Long id) {
        for (Job job: jobs){
            if(job.getId().equals(id)){
                this.jobs.remove(job);
                return true;
            }
        } 
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job job: jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        } 
        return false;
    }   
}
