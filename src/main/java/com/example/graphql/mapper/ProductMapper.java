package com.example.graphql.mapper;

import com.example.graphql.dto.response.ProductResponseDto;
import com.example.graphql.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Mappable<Product, ProductResponseDto>{

}