package com.example.demo.repository;

import com.example.demo.domain.ParentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentDetailRepository extends JpaRepository<ParentDetail, Long> {
}
