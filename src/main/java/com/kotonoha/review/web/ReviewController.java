package com.kotonoha.review.web;

import com.kotonoha.review.dto.ReviewRequest;
import com.kotonoha.review.model.Place;
import com.kotonoha.review.model.Review;
import com.kotonoha.review.repo.PlaceRepository;
import com.kotonoha.review.repo.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Cho phép React gọi API
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
  private final ReviewRepository reviewRepository;

  public ReviewController(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @GetMapping
  public List<Review> getAll() {
    return reviewRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Review review) {
    Review saved = reviewRepository.save(review);
    return ResponseEntity.ok(saved);
  }
}
