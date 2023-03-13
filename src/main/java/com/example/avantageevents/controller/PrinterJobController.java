package com.example.avantageevents.controller;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.PrinterJob;
import com.example.avantageevents.service.PrinterJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/printer")
@RequiredArgsConstructor
public class PrinterJobController {
    private final PrinterJobService printerJobService;


    @PostMapping
    public ResponseEntity<?> add(@RequestParam Long userId, @RequestParam Long eventId){
        ApiResponse<PrinterJob> response = printerJobService.add(userId, eventId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
