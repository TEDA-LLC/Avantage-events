package com.example.avantageevents.service;

import com.example.avantageevents.dto.AddressDTO;
import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.dto.ProductDTO;
import com.example.avantageevents.model.*;
import com.example.avantageevents.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:28   *  AvantageEvents
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    @Value("${company.department.id}")
    private Long departmentId;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttachmentRepository attachmentRepository;
    private final DistrictRepository districtRepository;
    private final UserRepository userRepository;

    public ApiResponse<List<Product>> getAll() {
        List<Product> products = productRepository.findAllByActiveTrueAndCategory_Department_Id(departmentId);
        return ApiResponse.<List<Product>>builder().
                message("Here").
                status(200).
                success(true).
                data(products).
                build();
    }


    public ApiResponse<Product> getOne(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty() || !optionalProduct.get().getCategory().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.<Product>builder().
                    message("Not Found").
                    status(204).
                    success(false).
                    build();
        } else {
            return ApiResponse.<Product>builder().
                    message("Here").
                    status(200).
                    success(true).
                    data(optionalProduct.get()).
                    build();
        }
    }

    @SneakyThrows
    public ApiResponse<?> save(ProductDTO productDTO) {
        Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
        if (categoryOptional.isEmpty() || !categoryOptional.get().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.builder().
                    message("Category not found").
                    status(400).
                    success(false).
                    build();
        }
        Product product = new Product();
        if (productDTO.getAttachment() != null && !productDTO.getAttachment().isEmpty()) {
            MultipartFile photo = productDTO.getAttachment();
            Attachment attachment = new Attachment();
            attachment.setBytes(photo.getBytes());
            attachment.setOriginalName(photo.getOriginalFilename());
            attachment.setContentType(photo.getContentType());
            attachment.setSize(photo.getSize());
            product.setAttachment(attachment);
        }
        if (productDTO.getAddress() != null) {
            AddressDTO addressDTO = productDTO.getAddress();
            Address address = new Address();
            Optional<District> districtOptional = districtRepository.findById(addressDTO.getDistrictId());
            if (districtOptional.isEmpty()) {
                return ApiResponse.builder().
                        message("District not found").
                        status(400).
                        success(false).
                        build();
            }
            address.setDistrict(districtOptional.get());
            address.setLatitude(addressDTO.getLatitude());
            address.setLongitude(addressDTO.getLongitude());
            address.setStreetHome(addressDTO.getStreetHome());
            product.setAddress(address);
        }
        product.setCategory(categoryOptional.get());
        product.setPrice(productDTO.getPrice());
        product.setNameRu(productDTO.getNameRu());
        product.setNameUz(productDTO.getNameUz());
        product.setNameEn(productDTO.getNameEn());
        product.setDescriptionRu(productDTO.getDescriptionRu());
        product.setDescriptionUz(productDTO.getDescriptionUz());
        product.setDescriptionEn(productDTO.getDescriptionEn());
        LocalDateTime from = LocalDateTime.parse(productDTO.getFrom());
        LocalDateTime to = LocalDateTime.parse(productDTO.getTo());
        if (productDTO.getFrom() != null) {
            if (LocalDateTime.now().isAfter(from)) {
                product.setFromDate(from);
            } else {
                return ApiResponse.builder().
                        message("Wrong start data time!!!").
                        status(400).
                        success(false).
                        build();
            }
        }
        if (productDTO.getTo() != null) {
            if (LocalDateTime.now().isAfter(to) && from.isAfter(to)) {
                product.setToDate(to);
            }
            else {
                return ApiResponse.builder().
                        message("Wrong finish data time!!!").
                        status(400).
                        success(false).
                        build();
            }
        }
        if (productDTO.getSpeakersId() != null && !productDTO.getSpeakersId().isEmpty()) {
            List<User> speakersList = userRepository.findAllById(productDTO.getSpeakersId());
            product.setSpeakers(speakersList);
        }

        productRepository.save(product);
        productRepository.save(product);

        return ApiResponse.builder().
                message("Saved").
                status(200).
                success(true).
                build();
    }

    @SneakyThrows
    public ApiResponse<?> edit(ProductDTO productDTO, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if (optionalProduct.isEmpty()) {
            return ApiResponse.builder().
                    message("Product Not Found").
                    status(204).
                    success(false).
                    build();
        }
        if (optionalCategory.isEmpty() || !optionalCategory.get().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.builder().
                    message("Category Not Found").
                    status(204).
                    success(false).
                    build();
        }
        Product product = optionalProduct.get();
        if (productDTO.getAttachment() != null) {
            MultipartFile photo = productDTO.getAttachment();
            Attachment attachment = new Attachment();
            if (product.getAttachment() != null)
                attachment = product.getAttachment();
            attachment.setBytes(photo.getBytes());
            attachment.setOriginalName(photo.getOriginalFilename());
            attachment.setContentType(photo.getContentType());
            attachment.setSize(photo.getSize());
            product.setAttachment(attachment);
        }
        if (productDTO.getAddress() != null) {
            AddressDTO addressDTO = productDTO.getAddress();
            Address address = new Address();
            if (product.getAddress() != null) {
                address = product.getAddress();
            }
            Optional<District> districtOptional = districtRepository.findById(addressDTO.getDistrictId());
            if (districtOptional.isEmpty()) {
                return ApiResponse.builder().
                        message("District not found").
                        status(400).
                        success(false).
                        build();
            }
            address.setDistrict(districtOptional.get());
            address.setLatitude(addressDTO.getLatitude());
            address.setLongitude(addressDTO.getLongitude());
            address.setStreetHome(addressDTO.getStreetHome());
            product.setAddress(address);
        }
        LocalDateTime from = LocalDateTime.parse(productDTO.getFrom());
        LocalDateTime to = LocalDateTime.parse(productDTO.getTo());
        if (productDTO.getFrom() != null) {
            if (LocalDateTime.now().isAfter(from)) {
                product.setFromDate(from);
            } else {
                return ApiResponse.builder().
                        message("Wrong start data time!!!").
                        status(400).
                        success(false).
                        build();
            }
        }
        if (productDTO.getTo() != null) {
            if (LocalDateTime.now().isAfter(to) && from.isAfter(to)) {
                product.setToDate(to);
            }
            else {
                return ApiResponse.builder().
                        message("Wrong finish data time!!!").
                        status(400).
                        success(false).
                        build();
            }
        }
        product.setNameUz(productDTO.getNameUz());
        product.setNameRu(productDTO.getNameRu());
        product.setNameEn(productDTO.getNameEn());
        product.setDescriptionUz(productDTO.getNameUz());
        product.setDescriptionRu(productDTO.getDescriptionRu());
        product.setDescriptionEn(productDTO.getDescriptionEn());
        product.setPrice(productDTO.getPrice());
        product.setCategory(optionalCategory.get());
        if (productDTO.getSpeakersId() != null && !productDTO.getSpeakersId().isEmpty()) {
            List<User> speakersList = userRepository.findAllById(productDTO.getSpeakersId());
            product.setSpeakers(speakersList);
        }

        productRepository.save(product);

        return ApiResponse.builder().
                message("Edited !").
                status(200).
                success(true).
                build();
    }

    public ApiResponse<?> delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty() || !optionalProduct.get().getCategory().getDepartment().getId().equals(departmentId)) {
            return ApiResponse.builder().
                    message("Product Not Found").
                    status(204).
                    success(false).
                    build();
        }
        Product product = optionalProduct.get();
        product.setActive(false);
        productRepository.save(product);
        return ApiResponse.builder().
                message("Deleted").
                status(201).
                success(true).
                build();
    }

    public ResponseEntity<?> getPhoto(Long id) {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if (attachmentOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Photo not found!!!");
        }
        Attachment attachment = attachmentOptional.get();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .contentLength(attachment.getSize())
                .body(attachment.getBytes());
    }

}
