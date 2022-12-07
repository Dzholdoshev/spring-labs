package com.cydeo.lab08rest.mapper;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    private final ModelMapper modelMapper;

    public AddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Address convertToEntity(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }

    public AddressDTO convertToDto(Address entity){
        return modelMapper.map(entity,AddressDTO.class);
    }


}
