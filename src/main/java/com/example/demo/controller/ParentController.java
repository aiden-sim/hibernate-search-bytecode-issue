package com.example.demo.controller;

import com.example.demo.domain.Parent;
import com.example.demo.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping("/{id}")
    public Parent get(@PathVariable("id") Long id) {
        Parent parent = parentService.getParent(id);

        // aspectjweaver
        parent.getParentDetails();
        return parent;
    }
}
