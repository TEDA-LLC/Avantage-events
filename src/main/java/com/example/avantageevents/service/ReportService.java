package com.example.avantageevents.service;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.Request;
import com.example.avantageevents.model.User;
import com.example.avantageevents.model.UserHistory;
import com.example.avantageevents.model.WordHistory;
import com.example.avantageevents.repository.ProductRepository;
import com.example.avantageevents.repository.RequestRepository;
import com.example.avantageevents.repository.UserHistoryRepository;
import com.example.avantageevents.repository.UserRepository;
import com.example.avantageevents.repository.WordHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:38   *  AvantageEvents
 */
@Service
@RequiredArgsConstructor
public class ReportService {

    //    @Value("${telegram.bot.id}")
//    private Long botId;
    @Value("${company.department.id}")
    private Long departmentId;
    private final UserRepository userRepository;
    private final UserHistoryRepository userHistoryRepository;
    private final ProductRepository productRepository;
    private final WordHistoryRepository wordHistoryRepository;
    private final RequestRepository requestRepository;

    public ApiResponse<List<User>> getAll() {
        List<User> users = userRepository.findAllByDepartment_Id(departmentId);
        return ApiResponse.<List<User>>builder().
                message("Here").
                status(200).
                success(true).
                data(users).
                build();
    }

    public ApiResponse<List<UserHistory>> getUserHistory() {
        List<UserHistory> histories = userHistoryRepository.findAllByUser_Department_Id(departmentId);
        return ApiResponse.<List<UserHistory>>builder().
                message("Here").
                status(200).
                success(true).
                data(histories).
                build();
    }

    public ApiResponse<?> getAmountByProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty() || !productOptional.get().getCategory().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.builder().
                    message("Product Not Found").
                    status(400).
                    success(false).
                    build();
        } else {
            long amount = userHistoryRepository.getAmountByProduct(productId);
            return ApiResponse.builder().
                    message("Here").
                    status(200).
                    success(true).
                    data(amount).
                    build();
        }
    }
    public ApiResponse<List<WordHistory>> getWordsHistory() {
        List<WordHistory> history = wordHistoryRepository.findAllByUser_Department_Id(departmentId);
        return ApiResponse.<List<WordHistory>>builder().
                message("Here").
                status(200).
                success(true).
                data(history).
                build();
    }

    public ApiResponse<?> editView(Long requestId) {
        Optional<Request> requestOptional = requestRepository.findById(requestId);
        if (requestOptional.isEmpty()|| !requestOptional.get().getUser().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.builder().
                    message("Request id not found !").
                    status(400).
                    success(false).
                    build();
        }
        Request request = requestOptional.get();
        request.setView(true);
        requestRepository.save(request);
        return ApiResponse.builder().
                message("Edited !").
                status(201).
                success(true).
                build();
    }

}
