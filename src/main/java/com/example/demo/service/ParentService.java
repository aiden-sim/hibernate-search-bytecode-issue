package com.example.demo.service;

import com.example.demo.domain.Parent;
import com.example.demo.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentService {
    private final ParentRepository parentRepository;

    public Parent getParent(Long id) {
        return parentRepository.getReferenceById(id);
    }
}
