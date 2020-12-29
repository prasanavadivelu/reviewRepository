package com.review.service;

import java.util.List;
import com.review.entity.Review;

public interface ReviewService {

	public void insert(Review review) ;
	
	public Review insertWithCommentsAndStarRatings(int reviewId, Review review);

	public Review getReviewById(int reviewId);

	public List<Review> getAllReview();

	public void deleteReview(int reviewId);
	
	public double getAverage(int[] reviews);

}
