package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.CustomerMapper;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getCustomerList() {
        List<Customer> customerList =  customerRepository.findAll();
        return customerList.stream()
                .map(customerMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomerListByEmail(String email) {
        List<Customer> customerList =  customerRepository.retrieveByCustomerEmail(email);
        List<CustomerDTO> customerDTOList = customerList.stream()
                .map(customerMapper::convertToDto)
                .collect(Collectors.toList());
        return customerDTOList;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerMapper.convertToEntity(customerDTO));

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(customerMapper.convertToEntity(customerDTO));
    }
}
