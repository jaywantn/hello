package com.myjava.hello.review.impl;

import java.util.List;
import java.util.Optional;

import com.myjava.hello.company.CompanyService;
import com.myjava.hello.review.Review;
import com.myjava.hello.review.ReviewRespository;
import com.myjava.hello.review.ReviewService;

public class ReviewServiceImpl implements ReviewService{
    private ReviewRespository reviewRespository;
    private CompanyService companyService;
    
    public ReviewServiceImpl(ReviewRespository reviewRespository, CompanyService companyService) {
        this.reviewRespository = reviewRespository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReview(Long companyId) {
        List<Review> reviews= reviewRespository.findByCompanyId(companyId);
        return reviews;
    }


    @Override
    public Review getReview(Long companyId, Long id) {
        List<Review> reviews= reviewRespository.findByCompanyId(companyId); 
        return reviews.stream().filter(review -> review.getId().equals(id))
        .findFirst().orElse(null);
    }


    @Override
    public boolean addReview(Long companyId, Review review) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addReview'");
    }


    @Override
    public boolean updateReview(Long companyId, Long id, Review updateReview) {
      if(companyService.getCompanyById(companyId) != null){
        updateReview.setCompany(companyService.getCompanyById(companyId));
        updateReview.setId(id);
        reviewRespository.save(updateReview);
        return true;
      }
      else{
        return false;
      }
    }
    
}
