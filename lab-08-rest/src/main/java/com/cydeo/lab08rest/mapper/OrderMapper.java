package com.cydeo.lab08rest.mapper;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Order convertToEntity(OrderDTO dto) {
        return modelMapper.map(dto, Order.class);
    }

    public OrderDTO convertToDto(Order entity){
        return modelMapper.map(entity,OrderDTO.class);
    }
}
