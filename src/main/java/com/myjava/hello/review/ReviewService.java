package com.myjava.hello.review;

import java.util.List;

public interface ReviewService {
 List<Review> getAllReview(Long companyId);

Review getReview(Long companyId, Long id);

boolean addReview(Long companyId, Review review);

boolean updateReview(Long companyId, Long id, Review review);
}
