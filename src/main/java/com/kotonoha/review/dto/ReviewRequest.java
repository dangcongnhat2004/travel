package com.kotonoha.review.dto;

import com.kotonoha.review.model.Category;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
public class ReviewRequest {
  @NotBlank private String title;
  private Category category;
  @Min(1) @Max(5) private int rating;
  private String content;
  private String imageUrl;
  private Long placeId;
}
