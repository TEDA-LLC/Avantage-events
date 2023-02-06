package com.example.avantageevents.service;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.Category;
import com.example.avantageevents.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:19   *  AvantageEvents
 */

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Value("${telegram.bot.id}")
    private Long botId;
    private final CategoryRepository categoryRepository;

    public ApiResponse<List<Category>> getAll() {
        List<Category> categories = categoryRepository.findAllByBot_Id(botId);
        return ApiResponse.<List<Category>>builder().
                message("Here").
                status(200).
                success(true).
                data(categories).
                build();
    }

}
