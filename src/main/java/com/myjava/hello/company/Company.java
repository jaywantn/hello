package com.myjava.hello.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myjava.hello.job.Job;
import com.myjava.hello.review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String address;
    private String location;
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy  ="company")
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy ="company")
    private List<Review> review;
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Company() {
    }
    
    public Company(Long id, String name, String address, String location, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    } 


}
