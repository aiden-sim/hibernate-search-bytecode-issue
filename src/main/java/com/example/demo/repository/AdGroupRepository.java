package com.example.demo.repository;

import com.example.demo.domain.AdGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdGroupRepository extends JpaRepository<AdGroup, Long> {
    Optional<AdGroup> findByIdAndStatus(Long id, String status);
}
