package com.kotonoha.review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "review")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String category;
  private int rating;

  @Column(columnDefinition = "TEXT")
  private String content;

  private String imageUrl;

  @CreationTimestamp
  private LocalDateTime createdAt;
}