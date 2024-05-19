package com.example.graphql.service.impl;

import com.example.graphql.dto.request.ProductRequestDto;
import com.example.graphql.dto.response.ProductResponseDto;
import com.example.graphql.entity.Product;
import com.example.graphql.mapper.ProductMapper;
import com.example.graphql.repository.ProductRepository;
import com.example.graphql.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto getById(Long  id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Product not found with id: " + id));
        return  productMapper.toDto(product);
    }

//    @Override
//    public ProductResponseDto update(ProductRequestDto productRequestDto) {
//        Product product = productRepository.findById(productRequestDto.getId())
//                .orElseThrow(() ->new EntityNotFoundException("Product not found with id: " + productRequestDto.getId()));
//
//        product.setId(productRequestDto.getId());
//        product.setName(productRequestDto.getName());
//        product.setDescription(productRequestDto.getDescription());
//        product.setPrice(productRequestDto.getPrice());
//        product.setUrl(productRequestDto.getUrl());
//
//        productRepository.save(product);
//
//        return productMapper.toDto(product);
//    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }

    @Transactional
    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {

        log.info(productRequestDto.getName());

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .url(productRequestDto.getUrl())
                .build();

        productRepository.save(product);

        return productMapper.toDto(product);
    }
}
