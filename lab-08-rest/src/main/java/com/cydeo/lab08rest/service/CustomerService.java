package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
   List<CustomerDTO> getCustomerList();
   List<CustomerDTO> getCustomerListByEmail(String email);
   void createCustomer(CustomerDTO customerDTO);
   void updateCustomer(CustomerDTO customerDTO);
   CustomerDTO findById(Long customerId);


}
