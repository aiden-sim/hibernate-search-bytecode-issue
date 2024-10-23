package com.example.demo.controller;

import com.example.demo.service.CreativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creative")
@RequiredArgsConstructor
public class CreativeController {
    private final CreativeService creativeService;

    @GetMapping("/create")
    public void create() {
        creativeService.create();
    }

    @GetMapping("/{id}/adGroup/{adgroupId}")
    public void get(@PathVariable("id") Long id,
                    @PathVariable("adgroupId") Long adgroupId) {
        creativeService.getCreatives(List.of(id), adgroupId);
    }
}
