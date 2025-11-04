package com.kotonoha.review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.Instant;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Review {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String title;

  @Enumerated(EnumType.STRING)
  private Category category;

  @Min(1) @Max(5)
  private int rating;

  @Column(length=4000)
  private String content;

  private String imageUrl;

  private Instant createdAt = Instant.now();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="place_id")
  private Place place;
}
