package com.kotonoha.review.web;

import com.kotonoha.review.dto.ReviewRequest;
import com.kotonoha.review.model.Place;
import com.kotonoha.review.model.Review;
import com.kotonoha.review.repo.PlaceRepository;
import com.kotonoha.review.repo.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

  private final ReviewRepository reviewRepo;
  private final PlaceRepository placeRepo;

  public ReviewController(ReviewRepository reviewRepo, PlaceRepository placeRepo) {
    this.reviewRepo = reviewRepo;
    this.placeRepo = placeRepo;
  }

  @GetMapping("/reviews")
  public List<Review> all() {
    return reviewRepo.findAll();
  }

  @PostMapping("/reviews")
  public ResponseEntity<Review> create(@Valid @RequestBody ReviewRequest req) {
    Place place = null;
    if (req.getPlaceId() != null) {
      place = placeRepo.findById(req.getPlaceId()).orElse(null);
    }
    Review r = Review.builder()
        .title(req.getTitle())
        .category(req.getCategory())
        .rating(req.getRating())
        .content(req.getContent())
        .imageUrl(req.getImageUrl())
        .place(place)
        .build();
    return ResponseEntity.ok(reviewRepo.save(r));
  }

  @GetMapping("/places")
  public List<Place> places() { return placeRepo.findAll(); }
}
