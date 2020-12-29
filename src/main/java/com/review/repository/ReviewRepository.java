package com.review.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.review.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Integer>{

	Review findById(int bookId);
}
