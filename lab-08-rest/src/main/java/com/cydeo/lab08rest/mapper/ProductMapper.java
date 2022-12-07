package com.cydeo.lab08rest.mapper;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Product convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    public ProductDTO convertToDto(Product entity){
        return modelMapper.map(entity,ProductDTO.class);
    }
}
