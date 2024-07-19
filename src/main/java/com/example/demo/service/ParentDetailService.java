package com.example.demo.service;

import com.example.demo.domain.ParentDetail;
import com.example.demo.repository.ParentDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentDetailService {
    private final ParentDetailRepository parentDetailRepository;

    public ParentDetail getParentDetail(Long id) {
        return parentDetailRepository.getReferenceById(id);
    }
}
