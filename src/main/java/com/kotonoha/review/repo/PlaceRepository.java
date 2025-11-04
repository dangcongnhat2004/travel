package com.kotonoha.review.repo;

import com.kotonoha.review.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {}
