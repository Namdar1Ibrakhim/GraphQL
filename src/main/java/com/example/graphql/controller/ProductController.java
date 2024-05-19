package com.example.graphql.controller;

import com.example.graphql.dto.request.ProductRequestDto;
import com.example.graphql.dto.response.ProductResponseDto;
import com.example.graphql.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @QueryMapping(name = "productById")
    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable @Argument Long id) {
        return productService.getById(id);
    }

    @MutationMapping(name = "deleteProduct")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MutationMapping(name = "createProduct")
    @PostMapping
    public ProductResponseDto create(@Argument ProductRequestDto productRequestDto){
        log.info(productRequestDto.getName());
        return productService.create(productRequestDto);
    }


}
