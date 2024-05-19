package com.example.graphql.dto.response;

import com.example.graphql.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductResponseDto {

    private Long id;

    private String name;

    private String description;

    private String price;

    private String url;

}
