package com.myjava.hello.review;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/companies/{companyId}")

public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<java.util.List<Review>> getAllReview(@PathVariable Long companyId){
        return ResponseEntity.ok( reviewService.getAllReview(companyId));
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long id){
        return ResponseEntity.ok( reviewService.getReview(companyId, id));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewdSaved = reviewService.addReview(companyId, review);
        if(isReviewdSaved){
            return new ResponseEntity<>("Review added succesfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("review not added", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long id, @RequestBody Review review){
        boolean reviewupdate= reviewService.updateReview(companyId, id, review);
        if(reviewupdate){
            return new ResponseEntity<>("Review updated succesfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not updated ", HttpStatus.NOT_FOUND);
        }
    
    }
}
