package com.example.avantageevents.service;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.PrinterJob;
import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.Request;
import com.example.avantageevents.model.User;
import com.example.avantageevents.repository.PrinterJobRepository;
import com.example.avantageevents.repository.ProductRepository;
import com.example.avantageevents.repository.RequestRepository;
import com.example.avantageevents.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrinterJobService {
    @Value("${company.department.id}")
    private Long departmentId;
    private final PrinterJobRepository printerJobRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    public ApiResponse<PrinterJob> add(Long userId, Long eventId) {
        Optional<Product> productOptional = productRepository.findById(eventId);
        if (productOptional.isEmpty() || !productOptional.get().getCategory().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.<PrinterJob>builder().
                    message("Event not found!!!").
                    status(400).
                    success(false).
                    build();
        }
        Product product = productOptional.get();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty() || !userOptional.get().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.<PrinterJob>builder().
                    message("User not found!!!").
                    status(400).
                    success(false).
                    build();
        }
        User user = userOptional.get();
        List<Request> requestList = requestRepository.findAllByProductAndUser(product, user);
        if (requestList.isEmpty()) {
            return ApiResponse.<PrinterJob>builder().
                    message("This user isn't registered").
                    status(400).
                    success(false).
                    build();
        }
        Request request = requestList.get(0);
        PrinterJob printerJob = new PrinterJob();
        printerJob.setRequest(request);
        printerJob.setQrcode(request.getUser().getQrcode());
        PrinterJob save = printerJobRepository.save(printerJob);
        return ApiResponse.<PrinterJob>builder().
                message("Here").
                status(201).
                success(true).
                data(save).
                build();
    }
}
