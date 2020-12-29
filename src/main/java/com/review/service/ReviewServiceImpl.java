package com.review.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.entity.Review;
import com.review.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository repository;

	@Override
	public void insert(Review review) {
		repository.save(review);
	}
	
	@Override
	public Review insertWithCommentsAndStarRatings(int reviewId,Review review) {
		Review getReview = repository.findById(reviewId);
		getReview.setName(review.getName());
		getReview.setComments(review.getComments());
		getReview.setStarRatings(review.getStarRatings());
		return repository.save(getReview);
	}

	@Override
	public Review getReviewById(int reviewId) {
		return repository.findById(reviewId);
	}

	@Override
	public List<Review> getAllReview() {
		return (List<Review>) repository.findAll();
	}


	@Override
	public void deleteReview(int reviewId) {
		repository.deleteById(reviewId);
	}
	
	@Override
	public double getAverage(int[] reviews) {
		return Arrays.stream(reviews).average().orElse(Double.NaN);
	}


}
