package com.cydeo.lab08rest.mapper;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Customer convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }

    public CustomerDTO convertToDto(Customer entity){
        return modelMapper.map(entity,CustomerDTO.class);
    }

}
