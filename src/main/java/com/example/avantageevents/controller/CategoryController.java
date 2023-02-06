package com.example.avantageevents.controller;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.Category;
import com.example.avantageevents.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:17   *  AvantageEvents
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        ApiResponse<List<Category>> response = categoryService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
