package com.example.avantageevents.controller;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.dto.RequestDTO;
import com.example.avantageevents.dto.ReviewDTO;
import com.example.avantageevents.dto.UserDTO;
import com.example.avantageevents.model.Country;
import com.example.avantageevents.model.District;
import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.Region;
import com.example.avantageevents.model.Request;
import com.example.avantageevents.model.Review;
import com.example.avantageevents.model.SiteHistory;
import com.example.avantageevents.model.User;
import com.example.avantageevents.service.AddressService;
import com.example.avantageevents.service.ProductService;
import com.example.avantageevents.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:40   *  AvantageEvents
 */

@RestController
@RequestMapping("/api/site")
@RequiredArgsConstructor
public class SiteController {

    private final SiteService siteService;
    private final ProductService productService;
    private final AddressService addressService;
    @GetMapping("/request")
    public ResponseEntity<?> getRequest() {
        ApiResponse<List<Request>> response = siteService.getRequest();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/district")
    public ResponseEntity<?> getAllDistrict(@RequestParam(required = false) Long regionId){
        ApiResponse<List<District>> response = addressService.getAllDistricts(regionId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/region")
    public ResponseEntity<?> getAllRegion(@RequestParam(required = false) Long countryId){
        ApiResponse<List<Region>> response = addressService.getAllRegions(countryId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/country")
    public ResponseEntity<?> getAllCountry(){
        ApiResponse<List<Country>> response = addressService.getAllCountry();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto){
        ApiResponse<User> response = siteService.login(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("/check")
    public ResponseEntity<?> checkUser(@RequestParam(required = false) String email, @RequestParam(required = false) String phone){
        ApiResponse<User> response = siteService.checkUser(email, phone);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        ApiResponse<List<SiteHistory>> response = siteService.getSiteHistory();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RequestDTO dto) {
        ApiResponse<?> response = siteService.add(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/history")
    public ResponseEntity<?> main(@RequestBody SiteHistory history, @RequestParam(required = false) String phone, @RequestParam(required = false) String email) {
        ApiResponse<?> response = siteService.historyWriter(history, phone, email);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/review")
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO dto) {
        ApiResponse<?> response = siteService.addReview(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/review")
    public ResponseEntity<?> editStatusReview(@RequestParam Long id) {
        ApiResponse<?> response = siteService.editStatusReview(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<?> getReview(@PathVariable Long id) {
        ApiResponse<Review> response = siteService.getReview(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/review")
    public ResponseEntity<?> getReviews(@RequestParam Boolean active) {
        ApiResponse<List<Review>> response = siteService.getReviews(active);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/reviewusers")
    public ResponseEntity<?> getReviewforUsers(){
        ApiResponse<List<Review>> response = siteService.getReviewForUsers();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/requestsByUser/{id}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable Long id){
        ApiResponse<Map<String, List<Request>>> response = siteService.getRequestsByUser(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<?> sendMessage(@PathVariable Long id){
        ApiResponse<?> response = siteService.sendMessage(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/getQrCode")
    public ResponseEntity<?> getQrCode(@RequestParam Long userId, HttpServletResponse response){
        return siteService.getQrCode(userId, response);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getAll() {
        ApiResponse<List<Product>> response = productService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        ApiResponse<Product> response = productService.getOne(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/request")
    public ResponseEntity<?> editRequest(@RequestParam Long id){
        ApiResponse<?> response = siteService.editRequest(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getPhoto(@PathVariable Long id){
        return productService.getPhoto(id);
    }
    @PatchMapping("/editphoto")
    public ResponseEntity<?> editPhoto(@ModelAttribute MultipartFile photo){
        ApiResponse<?> response = siteService.editPhoto(photo);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
