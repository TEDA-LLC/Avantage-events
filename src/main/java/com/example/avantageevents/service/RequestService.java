package com.example.avantageevents.service;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.Request;
import com.example.avantageevents.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public List<Request> getProductUsersToExel(Long id) {
      return   requestRepository.findAllByProduct_Id(id);
    }


    public ApiResponse<?> getProductUsers(Long id) {
        List<Request> allByProductId = requestRepository.findAllByProduct_Id(id);
        if(allByProductId == null){
            return ApiResponse.builder()
                    .message(" Users not found ")
                    .status(404)
                    .success(false)
                    .build();
        }
        return ApiResponse.builder()
                .message(" Here !")
                .status(200)
                .success(true)
                .data(allByProductId)
                .build();
    }



}
