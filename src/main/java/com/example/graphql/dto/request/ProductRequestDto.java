package com.example.graphql.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;

    private String description;

    private String price;

    private String url;

}
