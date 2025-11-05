package com.kotonoha.review.repo;

import com.kotonoha.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findAllByOrderByCreatedAtDesc();

}
