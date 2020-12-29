package com.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Review")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reviewId;

	@Column(name="name")
	private String name;

	@Column(name="comments")
	private String comments;
	
	@Column(name="starRatings")
	private String starRatings;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getStarRatings() {
		return starRatings;
	}
	
	public void setStarRatings(String starRatings) {
		this.starRatings=starRatings;
	}

	

}
