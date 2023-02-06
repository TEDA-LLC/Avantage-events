package com.example.avantageevents.controller;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:38   *  AvantageEvents
 */

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    @GetMapping("/auth")
    public ResponseEntity<?> checkAuth(){
        return ResponseEntity.ok("Here !!!!! ");
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        ApiResponse<List<User>> response = reportService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/userHistory")
    public ResponseEntity<?> getUserHistory() {
        ApiResponse<List<UserHistory>> response = reportService.getUserHistory();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/amount/{productId}")
    public ResponseEntity<?> getAmountByProduct(@PathVariable Long productId) {
        ApiResponse<?> response = reportService.getAmountByProduct(productId);

        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/wordHistory")
    public ResponseEntity<?> getAllHistory() {
        ApiResponse<List<WordHistory>> response = reportService.getWordsHistory();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/view/{requestId}")
    public ResponseEntity<?> editView(@PathVariable Long requestId){
        ApiResponse<?> response = reportService.editView(requestId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
