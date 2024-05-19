package com.example.graphql.service;

import com.example.graphql.dto.request.ProductRequestDto;
import com.example.graphql.dto.response.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getById(Long id);

//    ProductResponseDto update(ProductRequestDto productRequestDto);

    void delete(Long id);

    ProductResponseDto create(ProductRequestDto productRequestDto);
}
