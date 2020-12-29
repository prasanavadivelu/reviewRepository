package com.review.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.review.entity.Review;
import com.review.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService service;

    @RequestMapping(method = RequestMethod.POST, value = "/addReview",   produces = MediaType.APPLICATION_JSON_VALUE)
    public Review addReview(@RequestBody Review review) {
    	service.insert(review);
    	return Response.status(200).review(review.getReviewId().toString()).build();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/createReview/{reviewId}")
    public Review createReview(@PathVariable int reviewId,Review review) {
    	return service.insertWithCommentsAndStarRatings(reviewId,review);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getReview/{reviewId}")
    public Review getReview(@PathVariable int reviewId) {
    	return service.getReviewById(reviewId);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getReviews")
    public List<Review> getAllReviews() {
    	return service.getAllReview();
    }
    @RequestMapping(value = "/getAverage/{reviews}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void getAverage(@RequestBody int[] reviews) {
        service.getAverage(reviews);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteReview/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
    	 service.deleteReview(reviewId);
    }
}
