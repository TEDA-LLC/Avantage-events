package com.example.avantageevents.controller;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.dto.VacancyDTO;
import com.example.avantageevents.model.Vacancy;
import com.example.avantageevents.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:46   *  AvantageEvents
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vacancy")
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        ApiResponse<List<Vacancy>> response = vacancyService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody VacancyDTO vacancyDTO) {
        ApiResponse<?> response = vacancyService.add(vacancyDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        ApiResponse<Vacancy> response = vacancyService.getOne(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody VacancyDTO vacancyDTO, @PathVariable Long id){
        ApiResponse<?> response = vacancyService.edit(vacancyDTO,id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ApiResponse<?> response = vacancyService.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
