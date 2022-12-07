package com.cydeo.lab08rest.mapper;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Discount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {
    private final ModelMapper modelMapper;

    public DiscountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Discount convertToEntity(DiscountDTO dto) {
        return modelMapper.map(dto, Discount.class);
    }

    public DiscountDTO convertToDto(Discount entity){
        return modelMapper.map(entity,DiscountDTO.class);
    }
}
